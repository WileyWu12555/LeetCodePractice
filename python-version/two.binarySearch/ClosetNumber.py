def closestNumber(A, target):
    if not A:
        return -1
    start, end = 0, len(A) - 1
    while start + 1 < end:
        mid = (start + end) // 2
        if A[mid] == target:
            return mid
        elif A[mid] > target:
            end = mid
        else:
            start = mid
    if A[end] - target > target - A[start]:
        return start
    else:
        return end

A = [1, 3, 3, 4]
target = 5
print(closestNumber(A, target))