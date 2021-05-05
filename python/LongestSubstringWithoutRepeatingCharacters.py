import typing


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        if not s or len(s) == 0:
            return 0
        charSet = {}
        l, r = 0, 0
        maxLen = 0
        while r < len(s):
            charSet[s[r]] = charSet.setdefault(s[r], 0) + 1
            while len(charSet) != r - l + 1 and l <= r:
                charSet[s[l]] -= 1
                if charSet[s[l]] == 0:
                    charSet.pop(s[l])
                l += 1
            maxLen = max(maxLen, len(charSet))
            r += 1

        return maxLen


if __name__ == '__main__':
    assert 3 == Solution().lengthOfLongestSubstring('abcabcbb')
    assert 3 == Solution().lengthOfLongestSubstring('pwwkew')
    assert 0 == Solution().lengthOfLongestSubstring('')
    assert 2 == Solution().lengthOfLongestSubstring('aab')