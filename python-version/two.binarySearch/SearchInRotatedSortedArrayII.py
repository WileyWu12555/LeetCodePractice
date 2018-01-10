"""
    @param A : an integer ratated sorted array and duplicates are allowed
    @param target : an integer to be searched
    @return : a boolean
    """
def search(self, A, target):
    # write your code here
    for num in A:
        if num == target:
            return True
    return False