# set number of nodes
set opt(nn) 50.0

# set activity file
set opt(af) $opt(config-path)
append opt(af) /activity_1.0.tcl

# set mobility file
set opt(mf) $opt(config-path)
append opt(mf) /mobility_1.0.tcl

# set start/stop time
set opt(start) 0.0
set opt(stop) 116.0

# set floor size
set opt(x) 302
set opt(y) 302
set opt(min-x) -2
set opt(min-y) -2
