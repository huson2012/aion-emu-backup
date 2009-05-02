/**
 * This file is part of aion-emu <aion-emu.com>.
 *
 * aion-emu is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * aion-emu is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with aion-emu.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.loginserver.model;

import java.sql.Timestamp;

/**
 * This class represents Account model
 *
 * @author SoulKeeper
 */
public class Account {

    /**
     * Id of account, object if assigned, null if not
     */
    private Integer id;

    /**
     * Account name
     */
    private String name;

    /**
     * Password hash
     */
    private String passwordHash;

    /**
     * Date of last activity.
     * Should be create date if creating new account
     */
    private Timestamp lastActive;

    /**
     * Date when account expires
     * Null if never
     */
    private Timestamp expirationTime;

    /**
     * Date when penalty expires
     * Null if never
     */
    private Timestamp penaltyEnd;

    /**
     * Access level of account
     * 0 = regular user, > 0 = GM
     */
    private byte accessLevel;

    /**
     * last server visited by user
     * -1 if none
     */
    private byte lastServer;

    /**
     * Last ip of user
     * -1 if none
     */
    private String lastIp;

    /**
     * The only ip that is allowed to this account
     */
    private String ipForce;

    /**
     * Returns true if account has active penalty
     *
     * @return true if account has active penalty
     */
    public boolean isPenaltyActive() {
        return penaltyEnd != null && penaltyEnd.getTime() >= System.currentTimeMillis();
    }

    /**
     * Returns true if account has expired
     *
     * @return true if account has expired
     */
    public boolean isExpired() {
        return expirationTime != null && expirationTime.getTime() < System.currentTimeMillis();
    }

    /**
     * Returns account id, null if not stored in DB
     *
     * @return account id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets account id
     *
     * @param id account id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Returns account name
     *
     * @return account name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets account name
     *
     * @param name account name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns password hash
     *
     * @return password hash
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Sets password hash
     *
     * @param passwordHash password hash
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Returns last activity of the user
     *
     * @return last activity of the user
     */
    public Timestamp getLastActive() {
        return lastActive;
    }

    /**
     * Sets lats activity time of the user
     *
     * @param lastActive last activity time of the user
     */
    public void setLastActive(Timestamp lastActive) {
        this.lastActive = lastActive;
    }

    /**
     * Returns expiration time of account
     *
     * @return expiration time of account (do we need it?)
     */
    public Timestamp getExpirationTime() {
        return expirationTime;
    }

    /**
     * Sets expiration time for account
     *
     * @param expirationTime expiration time for account
     */
    public void setExpirationTime(Timestamp expirationTime) {
        this.expirationTime = expirationTime;
    }

    /**
     * Returns penalty end time
     *
     * @return penalty end time
     */
    public Timestamp getPenaltyEnd() {
        return penaltyEnd;
    }

    /**
     * Sets penalty end time
     *
     * @param penaltyEnd penalty end time
     */
    public void setPenaltyEnd(Timestamp penaltyEnd) {
        this.penaltyEnd = penaltyEnd;
    }

    /**
     * Returns access level of account
     *
     * @return access level of account
     */
    public byte getAccessLevel() {
        return accessLevel;
    }

    /**
     * Sets access level of account
     *
     * @param accessLevel access level of account
     */
    public void setAccessLevel(byte accessLevel) {
        this.accessLevel = accessLevel;
    }

    /**
     * Returns last server that player visited
     *
     * @return last server that player visited
     */
    public byte getLastServer() {
        return lastServer;
    }

    /**
     * Sets last server that player visited
     *
     * @param lastServer last server that player visited
     */
    public void setLastServer(byte lastServer) {
        this.lastServer = lastServer;
    }

    /**
     * Returns last ip that player played from
     *
     * @return last ip that player played from
     */
    public String getLastIp() {
        return lastIp;
    }

    /**
     * Sets last ip that player players from
     *
     * @param lastIp last ip that player played from
     */
    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    /**
     * Returns IP that player is forced to use with his account
     *
     * @return ip that player is forsed to use with his account
     */
    public String getIpForce() {
        return ipForce;
    }

    /**
     * Sets ip that player has to use with his account
     *
     * @param ipForce sets ip that players has to use with his account
     */
    public void setIpForce(String ipForce) {
        this.ipForce = ipForce;
    }

    /**
     * Retunrns true if players name and password has are equals
     *
     * @param o another player to check
     * @return true if names and password hash matches
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account)) return false;

        Account account = (Account) o;

        //noinspection SimplifiableIfStatement
        if (name != null ? !name.equals(account.name) : account.name != null) return false;
        return !(passwordHash != null ? !passwordHash.equals(account.passwordHash) : account.passwordHash != null);

    }

    /**
     * Returns player hashcode.
     *
     * @return player hashcode
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (passwordHash != null ? passwordHash.hashCode() : 0);
        return result;
    }
}