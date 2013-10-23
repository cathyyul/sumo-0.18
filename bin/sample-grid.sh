#have no idea about the trip time
#the fact is # of trip = # of vehicles = $TRIPTIME
TRIPTIME=50
ROUTETIME=150
GRIDLENGTH=100
GRIDNUM=4
NAME=test
SUMOPATH=/home/yutingyu/sumo-0.18.0

mkdir $NAME
cd $NAME

#generate a grid map
#default value: length=100 number=5
../netgenerate -g --grid.length=$GRIDLENGTH --grid.number=$GRIDNUM -o $NAME.net.xml --plain-output-prefix $NAME 

#generate trip
#option: e (end time in seconds)
#python $SUMOPATH/tools/trip/randomTrips.py -n $NAME.net.xml -e $TRIPTIME -p 10 -o $NAME.trip.xml
python $SUMOPATH/tools/trip/randomTrips.py -n $NAME.net.xml -e $TRIPTIME  -o $NAME.trip.xml

##generate routes
../duarouter -t $NAME.trip.xml -n $NAME.net.xml -e $ROUTETIME -o $NAME.rou.xml

##generate configure file
echo "<configure>" > $NAME.sumocfg
echo "  <input>" >> $NAME.sumocfg
echo "    <net-file value=\"$NAME.net.xml\"/>" >> $NAME.sumocfg
echo "    <route-files value=\"$NAME.rou.xml\"/>" >> $NAME.sumocfg
echo "  </input>" >> $NAME.sumocfg
echo "  <time>" >> $NAME.sumocfg
echo "    <begin value=\"0\"/>" >> $NAME.sumocfg
echo "    <end value=\"$ROUTETIME\"/>" >> $NAME.sumocfg
echo "  </time>" >> $NAME.sumocfg
echo "</configure>" >> $NAME.sumocfg

#run sumo and get fcd output
#../sumo -c $NAME.sumocfg --fcd-output $NAME.fcd.xml
../sumo -c ../test-2/test.sumocfg --fcd-output test-2.fcd.xml

#generate qualnet mobility
sh $SUMOPATH/tools/bin/fcd-qualnet.sh $SUMOPATH $NAME.fcd.xml $NAME.mob
