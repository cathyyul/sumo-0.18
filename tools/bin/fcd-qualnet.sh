if [ $# != 3 ];then
    echo "Three Arguments"
    echo "SUMOPATH FCDFILE OUTPUTFILE"
    exit 1
fi


SUMOPATH=$1
FCDFILE=$2
OUTPUTFILE=$3

ENDTIME=$(grep "end value" $FCDFILE | grep -o "[0-9]*" )

for i in $(seq 0 $ENDTIME )
do
    time=$i.00
    sed -n "/<timestep time=\"$time\">/,/<\/timestep>/p" $FCDFILE > oneStepone
    grep 'vehicle' oneStepone > oneSteptwo
    time=$i.0
    awk -v tm="$time" '{print $2, tm, $3, $4, "0"}' oneSteptwo >> tmpfinal
    rm oneStepone
    rm oneSteptwo
done

sed 's/id=//g' tmpfinal | sed 's/x=//g' | sed 's/y=//g' | sed 's/\"//g' | sed 's/-//g' > qualnetone 
awk '{print $1+1, $2, $3, $4, $5}' qualnetone > qualnettwo
python $SUMOPATH/tools/bin/fixZeroMo.py qualnettwo > zeroQualnet
python $SUMOPATH/tools/bin/fixLeftMo.py qualnettwo > leftQualnet
cat zeroQualnet > unsortqualnet
cat leftQualnet >> unsortqualnet
sort -k2 -g unsortqualnet > $OUTPUTFILE 

rm tmpfinal
rm qualnetone
rm qualnettwo
rm zeroQualnet
rm leftQualnet
rm unsortqualnet
