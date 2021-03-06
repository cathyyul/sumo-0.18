#!/usr/bin/env python
"""
@file    embedded.py
@author  Lena Kalleske
@author  Daniel Krajzewicz
@author  Michael Behrisch
@date    2009-03-26
@version $Id: embedded.py 14233 2013-06-28 12:47:25Z behrisch $

Tutorial for traffic light control via the TraCI interface.

SUMO, Simulation of Urban MObility; see http://sumo.sourceforge.net/
Copyright (C) 2009-2013 DLR/TS, Germany
All rights reserved
"""

import os, sys, subprocess
# the embedded python does not add the current dir to the python path, so we need to do it
sys.path.append(os.path.dirname(__file__))
import runner


if runner.traci.isEmbedded():
    # this script has been called from the sumo-internal python interpreter
    # only execute the main control procedure
    runner.run()
else:
    options = runner.get_options()
    # this script has been called from the command line. It will start sumo with
    # this script as argument
    if options.nogui:
        sumoBinary = runner.checkBinary('sumo')
    else:
        # gui running probably does not work yet
        sumoBinary = runner.checkBinary('sumo-gui')

    # first, generate the route file for this simulation
    runner.generate_routefile()

    # call sumo with the request to run this very same script again in the internal interpreter
    # when this happens, the method traci.isEmbedded() in line 23 will evaluate to true
    # and then the run method will be called
    retCode = subprocess.call([sumoBinary, "-c", "data/cross.sumocfg",
                               "--remote-port", "0", "--python-script", __file__],
                              stdout=sys.stdout, stderr=sys.stderr)
    sys.exit(retCode)
