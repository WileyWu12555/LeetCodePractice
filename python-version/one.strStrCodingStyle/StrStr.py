def strStr(source, target):
    if source is None or target is None:
        return -1
    return source.find(target)

source = "abcdedfacbabc"
target = "df"
print(strStr(source, target))
