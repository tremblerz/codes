#!/usr/local/ActivePython-2.3/bin/python
import socket
import pySonic
import audioop
w=pySonic.World()
r=pySonic.Recorder()
#constants for sampling audio
rate=44000 #Usually we dont require this much of rate to transmit human voice. theoritically 8000Hz is ok.
bits=16    #The above statement hold good even for bits used to represent a single sample 
channels=1
buffer_duration=1
sample=pySonic.EmptySample(buffer_duration*rate,channels,bits,rate)
print "\t\t\t Simple VoIP  Txer -by Godson\n"
ip=raw_input("Dial a pyPhone  IP \t")
comp=raw_input("\n Select on from the following compression technique\n\t1.mue law\n\t2.ADPCM\n")
serv=socket.socket(socket.AF_INET,socket.SOCK_DGRAM)
serv.bind((socket.gethostname(),7777))
while True:   #A continuous loop of transmitter which keeps on collecting voice samples
    data=[]
    r.Start(sample,loopit=False)
    while r.CurrentSample<buffer_duration*rate:
        pos=r.CurrentSample
    r.Stop()
    data.append(sample.GetBytes(0,pos))
    bytes=''.join(data)
    if comp=='2':
        adpc=audioop.lin2adpcm(bytes,4,None) #using ADPCM compression technique
        print len(adpc[0]),'adpcm'    
        serv.sendto(adpc[0],(str(ip),777))
    else:
        ulaw=audioop.lin2ulaw(bytes,4)   #Using mue-law compression
        print len(ulaw),'ulaw'    
        serv.sendto(ulaw,(str(ip),777))
