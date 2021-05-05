import typing


class Solution:
    _nums = [
        'zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight',
        'nine'
    ]

    def getCharsCount(self, s: str):
        _chars = {}
        for c in s:
            _chars[c] = _chars.setdefault(c, 0) + 1
        return _chars

    def checkAndRemoveWord(self, chars: dict, c: str, dig: int, result: list):
        if chars.get(c):
            for i in range(chars.get(c)):
                for j in self._nums[dig]:
                    chars[j] -= 1
                    if chars[j] == 0:
                        chars.pop(j)
                result.append(dig)

    def originalDigits(self, s: str) -> str:
        _input = self.getCharsCount(s)
        _result = []
        self.checkAndRemoveWord(_input, 'z', 0, _result)
        self.checkAndRemoveWord(_input, 'w', 2, _result)
        self.checkAndRemoveWord(_input, 'u', 4, _result)
        self.checkAndRemoveWord(_input, 'x', 6, _result)
        self.checkAndRemoveWord(_input, 'o', 1, _result)
        self.checkAndRemoveWord(_input, 'r', 3, _result)
        self.checkAndRemoveWord(_input, 'f', 5, _result)
        self.checkAndRemoveWord(_input, 's', 7, _result)
        self.checkAndRemoveWord(_input, 'g', 8, _result)
        self.checkAndRemoveWord(_input, 'i', 9, _result)

        return ''.join(str(x) for x in sorted(_result))


if __name__ == '__main__':
    assert '012' == Solution().originalDigits('owoztneoer')
    assert '45' == Solution().originalDigits('fviefuro')
    assert '9' == Solution().originalDigits('nnei')