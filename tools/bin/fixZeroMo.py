#!/usr/bin/env python

from __future__ import with_statement
import sys

outx=800
outy=800
outz=0

def addhelp(filename=''):
    with open(filename) as f:
        input = f.readlines()
	nodeIdSet=[]
        for line in input:
            oneline = line.split()
	    nodeId = int(oneline[0])
	    if nodeId not in nodeIdSet:
		nodeIdSet.append(nodeId)
		time=float(float(oneline[1])-0.1)
		if time < 0:
		    print ' '.join(oneline)
		else:
		    print nodeId, 0.0, outx, outy, outz

if __name__ == "__main__":
    addhelp(sys.argv[1])
