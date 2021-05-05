from typing import List


#Letter Combinations of a Phone Number
class Solution:
    _mapping = [
        '', '', 'abc', 'def', 'ghi', 'jkl', 'mno', 'pqrs', 'tuv', 'wxyz'
    ]

    def letterCombinations(self, digits: str) -> List[str]:
        if not digits or len(digits) == 0:
            return []
        result = []
        num = int(digits[0])
        child = self.letterCombinations(digits[1:])
        for c in self._mapping[num]:
            for i in child:
                result.append(c + i)
            if not child or len(child) == 0:
                result.append(c)
        return result


if __name__ == '__main__':
    assert ['ad', 'ae', 'af', 'bd', 'be', 'bf', 'cd', 'ce',
            'cf'] == Solution().letterCombinations('23')
