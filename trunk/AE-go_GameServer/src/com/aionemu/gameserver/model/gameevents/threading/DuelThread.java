/*
 * This file is part of aion-emu <aion-emu.com>.
 *
 *  aion-emu is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  aion-emu is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with aion-emu.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.aionemu.gameserver.model.gameevents.threading;

import org.apache.log4j.Logger;

import com.aionemu.gameserver.model.gameevents.Duel;
import com.aionemu.gameserver.model.gameobjects.player.Player;

/**
 * @author xitanium
 *
 */
public class DuelThread extends Thread
{
	private Player _requester;
	private Player _responder;
	private static Logger	log = Logger.getLogger(DuelThread.class);
	
	public DuelThread(Player requester, Player responder) {
		_requester = requester;
		_responder = responder;
	}
	
	@SuppressWarnings("static-access")
	public void run() {
		
		int requesterHP = _requester.getLifeStats().getCurrentHp();
		int responderHP = _requester.getLifeStats().getCurrentHp();
		
		while(requesterHP > 0 && responderHP > 0) {
			try {
				Thread.currentThread().sleep(250);
			}
			catch(InterruptedException e) {
				log.error("Cannot sleep DuelThread", e);
			}
			
		}
		return;
	}
}