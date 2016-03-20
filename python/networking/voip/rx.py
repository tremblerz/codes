#!/usr/local/ActivePython-2.3/bin/python
import socket
import pySonic,time
import audioop
w=pySonic.World()
serv=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
serv.bind((socket.gethostname(),777))
print '\n'*90,"*"*80,"\n",' '*30,'VoIP Rxer by Godson','\n\n','*'*80,'\n'*17
ip=raw_input("\nEnter the IP of other machine \t")
comp=raw_input("\n Select one of the compression technique from the following \n\t1.mue law\n\t2.ADPCM\n")
#constants
rate=33000 # these things mean nothing. i forgot to remove them(used for some experimentation)
bits=8
channels=1
data=[]
def recv(bytes):    
    global channels,bits,rate #I used these constants for debugging, they are not used in present code
    sou=pySonic.Source()
    print "Received amount of data",len(bytes)           
    sou.Sound=pySonic.MemorySample(bytes,channels,16,44000) #It simply forms a chunk of audio from the received samples
    sou.Play()
    print "Playing..."
    while sou.IsPlaying():
       time.sleep(0)   #Lol do we need  this line!!!!!
while True:    #A continuous loop which keeps on receving,decompressing & playing the audio data.
    sample,client=serv.recvfrom(100000) #dont be scared by that number
    data.append(sample) #All samples were joined together to make a meaningful audio. 
    bytes=''.join(data) # usually this called buffering. This one considerably slows down the program
    data=[]
    print "decoding..."
    if comp=='1':
        ulaw=audioop.ulaw2lin(bytes,4) #recovering original samples
        recv(ulaw)
    else:
        k=audioop.adpcm2lin(bytes,4,None)        
        recv(k[0])   
