import requests

def is_ascii(s):
    return all(ord(c) < 128 for c in s)

URL = 'https://randomuser.me/api/'

PARAMS = {'results': 2000}

r = requests.get(url = URL, params = PARAMS)

data = r.json()

SQL = "INSERT IGNORE INTO people (firstname, lastname, email, phone) VALUES\n"

count = 0
for user in data['results']:
    if count == 1000:
        break
    
    firstname = user['name']['first']
    lastname = user['name']['last']
    email = user['email']
    phone = user['phone']

    if is_ascii(firstname) and is_ascii(lastname) \
       and is_ascii(email) and is_ascii(phone):
        LINE = f"(\'{firstname}\', \'{lastname}\', \'{email}\', \'{phone}\'),\n"
        SQL += LINE
        count += 1
        #print(LINE)
    
SQL.rstrip('\n')
SQL.rstrip(',')

with open(r'peopledata.sql', 'w+') as f:
    f.write(SQL)
