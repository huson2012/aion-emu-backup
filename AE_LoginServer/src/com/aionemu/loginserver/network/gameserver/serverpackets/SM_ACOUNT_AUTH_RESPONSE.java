/**
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
package com.aionemu.loginserver.network.gameserver.serverpackets;

import java.nio.ByteBuffer;

import com.aionemu.loginserver.network.gameserver.GsConnection;
import com.aionemu.loginserver.network.gameserver.GsServerPacket;

/**
 * In this packet LoginServer is answering on GameServer
 * request about valid authentication data and also sends
 * account name of user that is authenticating on GameServer.
 * @author -Nemesiss-
 *
 */
public class SM_ACOUNT_AUTH_RESPONSE extends GsServerPacket
{
	/**
	 * True if account is authenticated.
	 */
	private final boolean ok;
	/**
	 * account name
	 */
	private final String accountName;

	/**
	 * Constructor.
	 * 
	 * @param ok
	 * @param accountName
	 */
	public SM_ACOUNT_AUTH_RESPONSE(boolean ok, String accountName)
	{
		this.ok = ok;
		this.accountName = accountName;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void writeImpl(GsConnection con, ByteBuffer buf)
	{
		writeC(buf, 0x01);
		writeC(buf, ok? 1 : 0);
		if(ok)
			writeS(buf, accountName);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getType()
	{
		return "0x01 SM_ACOUNT_AUTH_RESPONSE";
	}
}