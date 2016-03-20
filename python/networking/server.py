from socket import *
def respondToClient(serverSocket):
	k=0
	while True:
		clientSocket,ipAndPort=serverSocket.accept()
		print "Incomming connection from ipaddress " + ipAndPort[0] + " from port " + str(ipAndPort[1])
		clientSocket.sendall("Your connection has been accepted !")
		clientRequest=clientSocket.recv(10000)
		print clientRequest
		clientSocket.close()
		k+=1
		print "total number of requests = "+ str(k)
def main():
	serverSocket = socket(AF_INET,SOCK_STREAM)
	serverSocket.bind(("localhost",8080))
	serverSocket.listen(10)
	respondToClient(serverSocket)
main()
