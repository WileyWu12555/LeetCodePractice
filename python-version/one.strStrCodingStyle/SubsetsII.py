def subsetsWithDup(S):
    # write your code here
    S.sort()
    p = [[S[x] for x in range(len(S)) if i>>x&1] for i in range(2**len(S))]
    func = lambda x,y:x if y in x else x + [y]
    import functools
    p = functools.reduce(func, [[], ] + p)
    return list(reversed(p))

A = [1, 3, 3, 4]
print(subsetsWithDup(A))