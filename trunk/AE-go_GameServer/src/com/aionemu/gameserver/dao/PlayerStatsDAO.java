/*
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

package com.aionemu.gameserver.dao;

import com.aionemu.commons.database.dao.DAO;
import com.aionemu.gameserver.model.gameobjects.stats.PlayerGameStats;
import com.aionemu.gameserver.model.gameobjects.stats.PlayerLifeStats;


/**
 * Created on: 15.07.2009 19:33:07
 * Edited On:  13.09.2009 19:48:00
 *
 * @author AEJTester
 */
public abstract class PlayerStatsDAO implements DAO
{
	/**
     * Returns unique identifier for PlayerItemsDAO
     *
     * @return unique identifier for PlayerItemsDAO
     */
	@Override
	public final String getClassName()
	{
		 return PlayerStatsDAO.class.getName();
	}

	/**
	 * Returns a list of Items for player
	 * @param playerId Player object id.
	 * @return a list of Items for player
	 */
	public abstract PlayerLifeStats loadLifeStats(final int playerId);
	
	public abstract PlayerGameStats loadGameStats(final int playerId);
	
	public abstract void storeLifeStats(final int playerId, final PlayerLifeStats pls);
	
	public abstract void storeGameStats(final int playerId, final PlayerGameStats pgs);
	
	public abstract void storeNewStats(final int playerId, final PlayerLifeStats pls, final PlayerGameStats pgs);
	
	public abstract void deleteStats(final int playerId);
}