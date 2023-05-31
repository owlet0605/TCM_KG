import json
import csv

def get_new_csv(path='tcmTable.csv'):
    return open(path, 'w', newline="", encoding='utf-8-sig')

csv_file = get_new_csv()
csv_write = csv.writer(csv_file)

def do():
    with open('data/tcmData.json', 'r', encoding='utf-8') as f:
        json_data = json.load(f)
        dbEntry = json_data['data']
    for Entry in dbEntry:
        if (not len(Entry) == 0) and (not len(Entry.get('中药名')) == 0):
            writerow = [Entry.get('中药名')]
            for key in Entry.keys():
                if not key == '中药名':
                    writerow.append(key)
                    writerow.append(Entry.get(key))
            if not len(writerow) == 0:
                csv_write.writerow(writerow)

if __name__ == "__main__":
    do()
