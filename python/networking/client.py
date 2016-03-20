from socket import *
def recieve(socket,chunkSize=5):
	chunk=[]
	while True:
		data=socket.recv(chunkSize)
		if not data:
			break
		else:
			chunk.append(data)
	return "".join(chunk)
		
def main():
	ip_add="localhost"
	port=8080
	myHTTPClientSocket = socket(AF_INET, SOCK_STREAM)
	myHTTPClientSocket.connect((ip_add,port))
	myHTTPClientSocket.sendall("GET /index.html HTTP/1.0\n\n")
	data=recieve(myHTTPClientSocket,10)
	print data
main()
