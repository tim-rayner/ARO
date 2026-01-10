package com.argus.domain.deed;

/**
 * DeedType represents a normalised, domain-level action ("Deed")
 * derived from one or more raw OSINT events.
 *
 * <p>
 * Deeds are immutable semantic signals emitted by the ingestion layer
 * and consumed by the Risk Engine to update risk scores.
 * </p>
 *
 * <p>
 * Each DeedType:
 * <ul>
 *   <li>Maps primarily to one risk dimension</li>
 *   <li>Has scoring meaning</li>
 *   <li>Is source-agnostic (GDELT, URLhaus, etc.)</li>
 * </ul>
 * </p>
 *
 * <p>
 * IMPORTANT:
 * - Do not remove or rename existing enum values (backwards compatibility)
 * - New types must only be appended
 * </p>
 */
public enum DeedType {

    /* ============================================================
     * GEOPOLITICAL DEEDS
     * ============================================================ */

    /** Sustained or active armed military conflict */
    ARMED_CONFLICT,

    /** Escalation of military posture, troop movement, or threats */
    MILITARY_ESCALATION,

    /** Coordinated attack attributed to terrorist organisations */
    TERRORIST_ATTACK,

    /** Internal armed conflict between factions within a state */
    CIVIL_WAR_ACTIVITY,

    /** Attempted or successful overthrow of a government */
    COUP_ATTEMPT,

    /** Declaration of emergency powers by a state */
    STATE_OF_EMERGENCY_DECLARED,

    /** External political or military interference in another state */
    FOREIGN_INTERVENTION,

    /** New sanctions imposed against a state or entity */
    SANCTIONS_IMPOSED,

    /** Expansion or tightening of existing sanctions */
    SANCTIONS_ESCALATED,

    /** Formal peace negotiations or ceasefire discussions */
    PEACE_TALKS_INITIATED,

    /** Territorial disputes or border-related confrontations */
    BORDER_DISPUTE,

    /** Organised movement seeking independence or secession */
    SECESSION_MOVEMENT,

    POLITICAL_UNREST,


    /* ============================================================
     * SOCIAL DEEDS
     * ============================================================ */

    /** Large-scale organised public demonstrations */
    MASS_PROTEST,

    /** Violent civil disorder involving destruction or clashes */
    RIOTING,

    /** Sustained instability including strikes or civil clashes */
    CIVIL_UNREST,

    /** Heavy-handed suppression by police or security forces */
    POLICE_CRACKDOWN,

    /** Nationwide or sector-wide labour stoppage */
    GENERAL_STRIKE,

    /** Escalating tensions or violence between ethnic groups */
    ETHNIC_TENSION,

    /** Religious-based unrest or conflict */
    RELIGIOUS_TENSION,

    /** Sudden increase in refugee or migrant movement */
    MIGRATION_SURGE,

    /** Shortage of food impacting civilian populations */
    FOOD_SHORTAGE,

    /** Public health emergency or epidemic outbreak */
    PUBLIC_HEALTH_EMERGENCY,


    /* ============================================================
     * CYBER DEEDS
     * ============================================================ */

    /** Active hosting or distribution of malicious software */
    MALWARE_DISTRIBUTION,

    /** Botnet command-and-control or large-scale bot activity */
    BOTNET_ACTIVITY,

    /** Coordinated ransomware campaign or outbreak */
    RANSOMWARE_CAMPAIGN,

    /** Confirmed exploitation of critical or zero-day vulnerability */
    CRITICAL_VULNERABILITY_EXPLOITED,

    /** Cyber espionage attributed to state or state-aligned actors */
    CYBER_ESPIONAGE,

    /** Confirmed cyber intrusion or breach */
    CYBER_ATTACK_CONFIRMED,

    /** Coordinated phishing or credential harvesting campaign */
    PHISHING_CAMPAIGN,

    /** Distributed denial-of-service attack */
    DDOS_ATTACK,

    /** Compromise of upstream suppliers or vendors */
    SUPPLY_CHAIN_ATTACK,

    /** Measurable surge in cyber criminal activity */
    CYBER_CRIME_SURGE,


    /* ============================================================
     * ECONOMIC DEEDS
     * ============================================================ */

    /** Sudden collapse in stock market or major indices */
    MARKET_CRASH,

    /** Rapid and abnormal devaluation of national currency */
    CURRENCY_DEVALUATION,

    /** Sharp and unexpected rise in inflation */
    INFLATION_SPIKE,

    /** Emergency or extreme interest rate adjustment */
    INTEREST_RATE_SHOCK,

    /** Banking system instability or bank failures */
    BANKING_CRISIS,

    /** Elevated risk of sovereign debt default */
    SOVEREIGN_DEFAULT_RISK,

    /** Restrictions placed on capital or financial flows */
    CAPITAL_CONTROLS,

    /** Economic consequences resulting from sanctions */
    SANCTIONS_ECONOMIC_IMPACT,

    /** Disruption to trade routes or supply chains */
    TRADE_DISRUPTION,

    /** Sudden increase in energy or fuel prices */
    ENERGY_PRICE_SHOCK,


    /* ============================================================
     * INFRASTRUCTURE DEEDS
     * ============================================================ */

    /** State-level internet or connectivity shutdown */
    INTERNET_SHUTDOWN,

    /** Large-scale electrical grid or power outage */
    POWER_GRID_FAILURE,

    /** Loss or contamination of water infrastructure */
    WATER_INFRASTRUCTURE_FAILURE,

    /** Major disruption to transport networks */
    TRANSPORT_DISRUPTION,

    /** Telecommunications outage affecting populations */
    TELECOM_OUTAGE,

    /** Physical attack on energy infrastructure */
    ENERGY_INFRA_ATTACK,

    /** Disruption of fuel or resource pipelines */
    PIPELINE_DISRUPTION,

    /** Interference with satellite or GPS systems */
    SATELLITE_DISRUPTION,

    /** Deliberate sabotage of critical infrastructure */
    CRITICAL_INFRA_SABOTAGE,


    /* ============================================================
     * CROSS-CUTTING / META DEEDS
     * ============================================================ */

    /** Elevated risk of systemic state failure */
    STATE_COLLAPSE_RISK,

    /** Political regime instability or loss of legitimacy */
    REGIME_INSTABILITY,

    /** Scarcity of critical natural or economic resources */
    RESOURCE_SCARCITY,

    /** Natural or climate-driven disaster affecting populations */
    CLIMATE_DISASTER,

    /** Coordinated influence, propaganda, or disinformation campaigns */
    INFORMATION_WARFARE,

    /** Interference in democratic or electoral processes */
    ELECTION_INTERFERENCE,

    /** Severe humanitarian crisis requiring international response */
    HUMANITARIAN_CRISIS
}