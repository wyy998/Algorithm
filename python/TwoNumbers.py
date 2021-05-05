from typing import List
from LList import buildLList, printLList


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:
        root = ListNode(0)
        work = root
        sum = 0
        while l1 or l2 or sum > 0:
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
            if sum > 0 or l1 or l2:
                work.next = ListNode(sum % 10)
                work = work.next
                sum = sum // 10
        if root.next:
            return root.next
        else:
            return root


if __name__ == '__main__':
    l1 = buildLList([1, 2, 3])
    l2 = buildLList([3, 3, 3, 2])
    print('Origin: ', printLList(l1), printLList(l2))
    # print('Reversed: ', printList(reverseList(root)))
    print('Sum: ', printLList(Solution().addTwoNumbers(l1, l2)))
