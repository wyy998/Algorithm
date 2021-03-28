from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        d = {}
        for i in range(len(nums)):
            d[nums[i]] = i
        for i in range(len(nums)):
            if target - nums[i] in d and d[target - nums[i]] != i:
                return [i, d[target - nums[i]]]
        return []


if __name__ == '__main__':
    s = Solution()
    assert sorted(s.twoSum([2, 7, 11, 15], 9), reverse=False) == [0, 1]
    assert sorted(s.twoSum([3, 2, 4], 6), reverse=False) == [1, 2]
