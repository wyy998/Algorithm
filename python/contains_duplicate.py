from typing import List

class Solution:
    def containsDuplicate(self, nums: List[int]) -> bool:
        d = set()
        for n in nums:
            if n in d:
                return True
            d.add(n)
        return False

if __name__ == '__main__':
    assert True == Solution().containsDuplicate([1,2,3,1])
    assert False == Solution().containsDuplicate([1,2,3])