import urllib2

APIToken = "" # PHPHive Truecaller API Token, Obtain it from https://tcapi.phphive.info/console/
no = "" # Any Number You Want to Search

request_headers = {
"X-User": "PHPHive"
}

# For Searching User Details
print "Searching for "+no;
request = urllib2.Request("https://tcapi.phphive.info/"+APIToken+"/search/"+no, headers=request_headers)
contents = urllib2.urlopen(request).read()
print contents
