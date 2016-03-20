import unirest
response = unirest.get("https://community-gaana.p.mashape.com/index.php?subtype=most_popular&type=song",
  headers={
    "X-Mashape-Key": "<required>",
    "Accept": "application/json"
  }
)
print str(response)
