from BaseHTTPServer import HTTPServer
from SimpleHTTPServer import SimpleHTTPRequestHandler
import os
os.chdir("/home/abhi/codes/python/networking/httpServer")
serv = HTTPServer(("localhost",80),SimpleHTTPRequestHandler)
serv.serve_forever()
