import Levenshtein

functions=[]
flag=0

with open("data/function1.txt", "r", encoding="utf-8") as fr_n:
    for line in fr_n.readlines():
        line = line.strip()
        if len(functions)==0:
            lines=[]
            lines.append(line)
            functions.append(lines)
        else:
            flag = 0
            for function in functions:
                for func in function:
                    if Levenshtein.ratio(line, func) >= 0.65:
                        function.append(line)
                        flag = 1
                        break
            if flag==0:
                lines = []
                lines.append(line)
                functions.append(lines)

with open('data/function2.txt', 'a', encoding='utf-8') as f:
    for function in functions:
        for func in function:
            f.write(func + ' ')
        f.write('\n')
    f.close()