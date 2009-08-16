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
package com.aionemu.gameserver.network.aion;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.aionemu.gameserver.network.aion.serverpackets.unk.*;
import com.aionemu.gameserver.network.aion.serverpackets.*;

/**
 * This class is holding opcodes for all server packets. It's used only to have all opcodes in one place
 * 
 * @author Luno
 * 
 */
public class ServerPacketsOpcodes
{
	private static Map<Class<? extends AionServerPacket>, Integer>	opcodes	= new HashMap<Class<? extends AionServerPacket>, Integer>();

	static
	{
		Set<Integer> idSet = new HashSet<Integer>();

		addPacketOpcode(SM_CUSTOM_PACKET.class, 99999, idSet); // fake packet
		
		addPacketOpcode(SM_UNKF5.class, Version.Chiness ? 0xF5 : 0x07, idSet);
		addPacketOpcode(SM_UNKEF.class, Version.Chiness ? 0xef : -1, idSet);
		addPacketOpcode(SM_UNKE7.class, Version.Chiness ? 0xe7 : -1, idSet);
		addPacketOpcode(SM_UNKE1.class, Version.Chiness ? 0xe1 : -1, idSet);
		addPacketOpcode(SM_UNKD9.class, Version.Chiness ? 0xD9 : 0xE3, idSet);
		addPacketOpcode(SM_UNKD3.class, Version.Chiness ? 0xd3 : -1, idSet);
		addPacketOpcode(SM_UNKCB.class, Version.Chiness ? 0xcb : -1, idSet);
		addPacketOpcode(SM_UNKC8.class, Version.Chiness ? 0xc8 : -1, idSet);
		addPacketOpcode(SM_UNKC7.class, Version.Chiness ? 0xc7 : -1, idSet);
		addPacketOpcode(SM_UNKC6.class, Version.Chiness ? 0xc6 : -1, idSet);
		addPacketOpcode(SM_UNKBD.class, Version.Chiness ? 0xBD : 0xCF, idSet);
		addPacketOpcode(SM_UNK97.class, Version.Chiness ? 0x97 : -1, idSet);
		addPacketOpcode(SM_UNK91.class, Version.Chiness ? 0x91 : -1, idSet);
		addPacketOpcode(SM_UNK8D.class, Version.Chiness ? 0x8d : -1, idSet);
		addPacketOpcode(SM_UNK66.class, Version.Chiness ? 0x66 : -1, idSet);
		addPacketOpcode(SM_UNK64.class, Version.Chiness ? 0x64 : -1, idSet);
		addPacketOpcode(SM_UNK60.class, Version.Chiness ? 0x60 : -1, idSet);
		addPacketOpcode(SM_UNK5E.class, Version.Chiness ? 0x5e : -1, idSet);
		addPacketOpcode(SM_UNK32.class, Version.Chiness ? 0x32 : -1, idSet);
		addPacketOpcode(SM_UNK17.class, Version.Chiness ? 0x17 : -1, idSet);
		addPacketOpcode(SM_UNK15.class, Version.Chiness ? 0x15 : -1, idSet);
		addPacketOpcode(SM_UNK0C.class, Version.Chiness ? 0x0C : 0xFC, idSet);
		addPacketOpcode(SM_UNK0A.class, Version.Chiness ? 0x0A : -1, idSet);
		addPacketOpcode(SM_VERSION_CHECK.class, Version.Chiness ? 0xF6 : 0xFE, idSet);
		addPacketOpcode(SM_SYSTEM_MESSAGE.class, Version.Chiness ? 0x2A : 0x1A, idSet);
		addPacketOpcode(SM_STATUPDATE_MP.class, Version.Chiness ? -1 : 0x14, idSet);
		addPacketOpcode(SM_STATUPDATE_HP.class, Version.Chiness ? -1 : 0x12, idSet);
		addPacketOpcode(SM_STATUPDATE_EXP.class, Version.Chiness ? -1 : 0x19, idSet);
		addPacketOpcode(SM_STATUPDATE_DP.class, Version.Chiness ? -1 : 0x17, idSet);
		addPacketOpcode(SM_STATS_INFO.class, Version.Chiness ? 0x29 : 0x13, idSet);
		addPacketOpcode(SM_SKILL_LIST.class, Version.Chiness ? 0x1D : 0x2F, idSet);
		addPacketOpcode(SM_RESTORE_CHARACTER.class, Version.Chiness ? 0xC1 : 0xCB, idSet);
		addPacketOpcode(SM_RECONNECT_KEY.class, Version.Chiness ? 0x0D : 0xFF, idSet);
		addPacketOpcode(SM_QUIT_RESPONSE.class, Version.Chiness ? 0x59 : 0x63, idSet);
		addPacketOpcode(SM_QUESTION_WINDOW.class, Version.Chiness ? -1 : 0x37, idSet);
		addPacketOpcode(SM_PONG.class, Version.Chiness ? 0x7C : 0x8C, idSet);
		addPacketOpcode(SM_PLAYER_STATE.class, Version.Chiness ? 0x33 : 0x45, idSet);
		addPacketOpcode(SM_PLAYER_INFO.class, Version.Chiness ? 0xFE : 0x06, idSet);
		addPacketOpcode(SM_NPC_INFO.class, Version.Chiness ? 0xFF : 0x09, idSet);
		addPacketOpcode(SM_NICKNAME_CHECK_RESPONSE.class, Version.Chiness ? 0xDF : 0xE9, idSet);
		addPacketOpcode(SM_MOVE.class, Version.Chiness ? 0x4F : 0x39, idSet);
		addPacketOpcode(SM_MESSAGE.class, Version.Chiness ? 0x31 : 0x1B, idSet);
		addPacketOpcode(SM_MAY_LOGIN_INTO_GAME.class, Version.Chiness ? 0x7F : 0x89, idSet);
		addPacketOpcode(SM_MACRO_LIST.class, Version.Chiness ? 0xD5 : 0xE7, idSet);
		addPacketOpcode(SM_L2AUTH_LOGIN_CHECK.class, Version.Chiness ? 0xB5 : 0xC7, idSet);
		addPacketOpcode(SM_KEY.class, Version.Chiness ? 0x3F : 0x49, idSet);
		addPacketOpcode(SM_INVENTORY_INFO.class, Version.Chiness ? 0x2B : 0x1D, idSet);
		addPacketOpcode(SM_GAME_TIME.class, Version.Chiness ? -1 : 0x27, idSet);
		addPacketOpcode(SM_FRIEND_RESPONSE.class, Version.Chiness ? -1 : 0xDC, idSet);
		addPacketOpcode(SM_FRIEND_NOTIFY.class, Version.Chiness ? -1 : 0xE1, idSet);
		addPacketOpcode(SM_FRIEND_LIST.class,Version.Chiness ? -1 : 0x82, idSet);
		addPacketOpcode(SM_ENTER_WORLD_CHECK.class, Version.Chiness ? 0xF4 : 0x04, idSet);
		addPacketOpcode(SM_EMOTION.class, Version.Chiness ? 0x14 : 0x24, idSet);
		addPacketOpcode(SM_DELETE.class, Version.Chiness ? 0xFB : 0x0D, idSet);
		addPacketOpcode(SM_DELETE_CHARACTER.class, Version.Chiness ? 0xC0 : 0xC8, idSet);
		addPacketOpcode(SM_CREATE_CHARACTER.class, Version.Chiness ? 0xBF : 0xC9, idSet);
		addPacketOpcode(SM_CHARACTER_LIST.class, Version.Chiness ? 0xBE : 0xC6, idSet);
	}

	static int getOpcode(Class<? extends AionServerPacket> packetClass)
	{
		Integer opcode = opcodes.get(packetClass);
		if(opcode == null)
			throw new IllegalArgumentException("There is no opcode for " + packetClass + " defined.");

		return opcode;
	}

	private static void addPacketOpcode(Class<? extends AionServerPacket> packetClass, int opcode, Set<Integer> idSet)
	{
		if(opcode < 0)
			return;

		if(idSet.contains(opcode))
			throw new IllegalArgumentException(String.format("There already exists another packet with id 0x%02X", opcode));

		
		idSet.add(opcode);
		opcodes.put(packetClass, opcode);
	}
}