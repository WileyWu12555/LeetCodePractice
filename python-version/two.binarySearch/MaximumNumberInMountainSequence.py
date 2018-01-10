def mountainSequence( nums):
    # Write your code here
    left, right = 0, len(nums) - 1
    while left + 1 < right:
        m1 = left + (right - left) // 2
        m2 = right - (right - m1) // 2
        if nums[m1] < nums[m2]:
            left = m1 + 1
        elif nums[m1] > nums[m2]:
            right = m2 - 1
        else:
            left = m1
            right = m2

    return max(nums[left], nums[right])

A = [1, 2, 4, 8, 6, 3]

print(mountainSequence(A))