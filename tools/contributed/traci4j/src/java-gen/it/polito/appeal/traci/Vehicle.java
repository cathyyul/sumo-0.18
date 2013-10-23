

/*
    THIS FILE IS GENERATED AUTOMATICALLY. DO NOT EDIT: CHANGES WILL BE OVERWRITTEN.
    File generated by traciObject.xslt.
*/

/*   
    Copyright (C) 2013 ApPeAL Group, Politecnico di Torino

    This file is part of TraCI4J.

    TraCI4J is free software: you can redistribute it and/or modify
    it under the terms of the GNU General Public License as published by
    the Free Software Foundation, either version 3 of the License, or
    (at your option) any later version.

    TraCI4J is distributed in the hope that it will be useful,
    but WITHOUT ANY WARRANTY; without even the implied warranty of
    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
    GNU General Public License for more details.

    You should have received a copy of the GNU General Public License
    along with TraCI4J.  If not, see <http://www.gnu.org/licenses/>.
*/


package it.polito.appeal.traci;

import java.io.DataInputStream;
import java.io.DataOutputStream;

/**

	Representation of a vehicle in the SUMO environment.
	@see <a href="http://sumo.sourceforge.net/doc/current/docs/userdoc/Definition_of_Vehicles,_Vehicle_Types,_and_Routes.html#Vehicle_Types">SUMO documentation</a>
	@author Enrico Gueli &lt;enrico.gueli@polito.it&gt;
	
*/
public class Vehicle 
extends TraciObject<Vehicle.Variable>
implements StepAdvanceListener
{

	/**
	 * Enumerates all the read queries. Each value can be used as an argument
	 * for {@link TraciObject#getReadQuery(Enum)}.
	 * 
	 * @author Enrico Gueli &lt;enrico.gueli@polito.it&gt;
	 */	
	public static enum Variable {
		
		/** 
		 * Query "ReadSpeed"
		 * @see {@link #queryReadSpeed}
		 */
		SPEED,
		
		/** 
		 * Query "ReadPosition"
		 * @see {@link #queryReadPosition}
		 */
		POSITION,
		
		/** 
		 * Query "ReadLanePosition"
		 * @see {@link #queryReadLanePosition}
		 */
		LANE_POSITION,
		
		/** 
		 * Query "ReadCurrentLaneIndex"
		 * @see {@link #queryReadCurrentLaneIndex}
		 */
		LANE_INDEX,
		
		/** 
		 * Query "ReadCurrentLane"
		 * @see {@link #queryReadCurrentLane}
		 */
		LANE_ID,
		
		/** 
		 * Query "ReadCurrentRoute"
		 * @see {@link #queryReadCurrentRoute}
		 */
		CURRENT_ROUTE,
		
		/** 
		 * Query "ReadCurrentEdge"
		 * @see {@link #queryReadCurrentEdge}
		 */
		CURRENT_EDGE,
		
		/** 
		 * Query "ReadCO2Emission"
		 * @see {@link #queryReadCO2Emission}
		 */
		CO2_EMISSION,
		
		/** 
		 * Query "ReadCOEmission"
		 * @see {@link #queryReadCOEmission}
		 */
		CO_EMISSION,
		
		/** 
		 * Query "ReadHCEmission"
		 * @see {@link #queryReadHCEmission}
		 */
		HC_EMISSION,
		
		/** 
		 * Query "ReadPMXEmission"
		 * @see {@link #queryReadPMXEmission}
		 */
		PMX_EMISSION,
		
		/** 
		 * Query "ReadNOXEmission"
		 * @see {@link #queryReadNOXEmission}
		 */
		NOX_EMISSION,
		
		/** 
		 * Query "ReadFuelConsumption"
		 * @see {@link #queryReadFuelConsumption}
		 */
		FUEL_CONSUMPTION,
		
		/** 
		 * Query "ReadNoiseEmission"
		 * @see {@link #queryReadNoiseEmission}
		 */
		NOISE_EMISSION,
		
	}
	
	
	private final ChangeEdgeTravelTimeQuery csqvar_SetEdgeTravelTime;
	
	private final RerouteQuery csqvar_Reroute;
	
	private final ChangeTargetQuery csqvar_ChangeTarget;
	
	private final ChangeMaxSpeedQuery csqvar_ChangeMaxSpeed;
	
	private final ChangeRouteQuery csqvar_ChangeRoute;
	Vehicle (
		DataInputStream dis,
		DataOutputStream dos, 
		String id
		
			, Repository<Edge> repoEdge
			, Repository<Lane> repoLane
	) {
		super(id, Variable.class);

		/*
		 * initialization of read queries
		 */
		
		addReadQuery(Variable.SPEED, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_SPEED
				
				));
		
		addReadQuery(Variable.POSITION, 
				new ReadObjectVarQuery.PositionQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_POSITION
				
				));
		
		addReadQuery(Variable.LANE_POSITION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_LANEPOSITION
				
				));
		
		addReadQuery(Variable.LANE_INDEX, 
				new ReadObjectVarQuery.IntegerQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_LANE_INDEX
				
				));
		
		addReadQuery(Variable.LANE_ID, 
				new ReadObjectVarQuery.LaneQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_LANE_ID
				, repoLane
				
				));
		
		addReadQuery(Variable.CURRENT_ROUTE, 
				new RouteQuery (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_EDGES
				, repoEdge
				
				));
		
		addReadQuery(Variable.CURRENT_EDGE, 
				new ReadObjectVarQuery.EdgeQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_ROAD_ID
				, repoEdge
				
				));
		
		addReadQuery(Variable.CO2_EMISSION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_CO2EMISSION
				
				));
		
		addReadQuery(Variable.CO_EMISSION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_COEMISSION
				
				));
		
		addReadQuery(Variable.HC_EMISSION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_HCEMISSION
				
				));
		
		addReadQuery(Variable.PMX_EMISSION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_PMXEMISSION
				
				));
		
		addReadQuery(Variable.NOX_EMISSION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_NOXEMISSION
				
				));
		
		addReadQuery(Variable.FUEL_CONSUMPTION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_FUELCONSUMPTION
				
				));
		
		addReadQuery(Variable.NOISE_EMISSION, 
				new ReadObjectVarQuery.DoubleQ (dis, dos, 
				it.polito.appeal.traci.protocol.Constants.CMD_GET_VEHICLE_VARIABLE, 
				id, 
				it.polito.appeal.traci.protocol.Constants.VAR_NOISEEMISSION
				
				));
		

		/*
		 * initialization of change state queries
		 */
		
		csqvar_SetEdgeTravelTime = new ChangeEdgeTravelTimeQuery(dis, dos, id
		)
		;
		
		csqvar_Reroute = new RerouteQuery(dis, dos, id
		)
		{
			@Override
			void pickResponses(java.util.Iterator<it.polito.appeal.traci.protocol.ResponseContainer> responseIterator)
					throws TraCIException {
				super.pickResponses(responseIterator);
				
				queryReadCurrentRoute().setObsolete();
				
			}
		};
		
		csqvar_ChangeTarget = new ChangeTargetQuery(dis, dos, id
		)
		{
			@Override
			void pickResponses(java.util.Iterator<it.polito.appeal.traci.protocol.ResponseContainer> responseIterator)
					throws TraCIException {
				super.pickResponses(responseIterator);
				
				queryReadCurrentRoute().setObsolete();
				
			}
		};
		
		csqvar_ChangeMaxSpeed = new ChangeMaxSpeedQuery(dis, dos, id
		)
		{
			@Override
			void pickResponses(java.util.Iterator<it.polito.appeal.traci.protocol.ResponseContainer> responseIterator)
					throws TraCIException {
				super.pickResponses(responseIterator);
				
			}
		};
		
		csqvar_ChangeRoute = new ChangeRouteQuery(dis, dos, id
		)
		{
			@Override
			void pickResponses(java.util.Iterator<it.polito.appeal.traci.protocol.ResponseContainer> responseIterator)
					throws TraCIException {
				super.pickResponses(responseIterator);
				
				queryReadCurrentRoute().setObsolete();
				
			}
		};
		
	
	}
	
	
	
	@Override
	public void nextStep(double step) {
		
		getReadQuery(Variable.SPEED).setObsolete();
		
		getReadQuery(Variable.POSITION).setObsolete();
		
		getReadQuery(Variable.LANE_POSITION).setObsolete();
		
		getReadQuery(Variable.LANE_INDEX).setObsolete();
		
		getReadQuery(Variable.LANE_ID).setObsolete();
		
		getReadQuery(Variable.CURRENT_EDGE).setObsolete();
		
		getReadQuery(Variable.CO2_EMISSION).setObsolete();
		
		getReadQuery(Variable.CO_EMISSION).setObsolete();
		
		getReadQuery(Variable.HC_EMISSION).setObsolete();
		
		getReadQuery(Variable.PMX_EMISSION).setObsolete();
		
		getReadQuery(Variable.NOX_EMISSION).setObsolete();
		
		getReadQuery(Variable.FUEL_CONSUMPTION).setObsolete();
		
		getReadQuery(Variable.NOISE_EMISSION).setObsolete();
		
	}
	
	
	
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadSpeed() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.SPEED);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.awt.geom.Point2D> queryReadPosition() {
		return (ReadObjectVarQuery.PositionQ) getReadQuery(Variable.POSITION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadLanePosition() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.LANE_POSITION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Integer> queryReadCurrentLaneIndex() {
		return (ReadObjectVarQuery.IntegerQ) getReadQuery(Variable.LANE_INDEX);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<Lane> queryReadCurrentLane() {
		return (ReadObjectVarQuery.LaneQ) getReadQuery(Variable.LANE_ID);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.util.List<Edge>> queryReadCurrentRoute() {
		return (RouteQuery) getReadQuery(Variable.CURRENT_ROUTE);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<Edge> queryReadCurrentEdge() {
		return (ReadObjectVarQuery.EdgeQ) getReadQuery(Variable.CURRENT_EDGE);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadCO2Emission() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.CO2_EMISSION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadCOEmission() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.CO_EMISSION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadHCEmission() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.HC_EMISSION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadPMXEmission() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.PMX_EMISSION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadNOXEmission() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.NOX_EMISSION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadFuelConsumption() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.FUEL_CONSUMPTION);
	}
	
	
	/**
	 * @return the instance of {@link ReadObjectVarQuery} relative to this query.
	 */
	public ReadObjectVarQuery<java.lang.Double> queryReadNoiseEmission() {
		return (ReadObjectVarQuery.DoubleQ) getReadQuery(Variable.NOISE_EMISSION);
	}
	
	
	/**
	 * @return the instance of {@link ChangeEdgeTravelTimeQuery} relative to this query.
	 */
	public ChangeEdgeTravelTimeQuery querySetEdgeTravelTime() {
		return csqvar_SetEdgeTravelTime;
	}
	
	/**
	 * @return the instance of {@link RerouteQuery} relative to this query.
	 */
	public RerouteQuery queryReroute() {
		return csqvar_Reroute;
	}
	
	/**
	 * @return the instance of {@link ChangeTargetQuery} relative to this query.
	 */
	public ChangeTargetQuery queryChangeTarget() {
		return csqvar_ChangeTarget;
	}
	
	/**
	 * @return the instance of {@link ChangeMaxSpeedQuery} relative to this query.
	 */
	public ChangeMaxSpeedQuery queryChangeMaxSpeed() {
		return csqvar_ChangeMaxSpeed;
	}
	
	/**
	 * @return the instance of {@link ChangeRouteQuery} relative to this query.
	 */
	public ChangeRouteQuery queryChangeRoute() {
		return csqvar_ChangeRoute;
	}
	
}
