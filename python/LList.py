from typing import List


# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


def reverseLList(root: ListNode) -> ListNode:
    if not root or not root.next:
        return root
    pre = None
    mid = root
    nxt = root.next
    while mid:
        mid.next = pre
        pre = mid
        mid = nxt
        if nxt:
            nxt = nxt.next
    return pre


def printLList(root: ListNode) -> List:
    result = []
    while root:
        result.append(root.val)
        root = root.next
    return result


def buildLList(list: List) -> ListNode:
    root = ListNode(0)
    work = root
    for l in list:
        work.next = ListNode(l)
        work = work.next
    return root.next
