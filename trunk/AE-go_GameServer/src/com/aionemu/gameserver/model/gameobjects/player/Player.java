package com.aionemu.gameserver.model.gameobjects.player;

import com.aionemu.commons.callbacks.Enhancable;
import com.aionemu.gameserver.controllers.PlayerController;
import com.aionemu.gameserver.model.Gender;
import com.aionemu.gameserver.model.PlayerClass;
import com.aionemu.gameserver.model.gameobjects.Creature;
import com.aionemu.gameserver.model.gameobjects.player.listeners.PlayerLoggedInListener;
import com.aionemu.gameserver.model.gameobjects.player.listeners.PlayerLoggedOutListener;
import com.aionemu.gameserver.network.aion.AionConnection;
import com.aionemu.gameserver.network.aion.serverpackets.SM_PLAYER_STATE;
import com.aionemu.gameserver.services.PlayerService;
import com.aionemu.gameserver.utils.PacketSendUtility;

/**
 * This class is representing Player object, it contains all needed data.
 * 
 * 
 * @author -Nemesiss-
 * @author SoulKeeper
 * @author alexa026
 * 
 */
public class Player extends Creature
{
	private PlayerAppearance	playerAppearance;
	private PlayerCommonData	playerCommonData;
	private MacroList			macroList;
	private SkillList			skillList;
	private FriendList			friendList;
	private BlockList			blockList;
	private ResponseRequester	requester;
	private boolean lookingForGroup = false;
	
	public long currentExp = 0;
	public long maxExp = 1000;
	public int itemid = 0; 
	public int kinah = 0;
	public int atcount = 1;
	
	/** When player enters game its char is in kind of "protection" state, when is blinking etc */
	private boolean				protectionActive;

	/**
	 * Connection of this Player.
	 */
	private AionConnection		clientConnection;

	public Player(PlayerController controller, PlayerCommonData plCommonData, PlayerAppearance appereance)
	{
		super(plCommonData.getPlayerObjId(), controller, plCommonData.getPosition());

		this.playerCommonData = plCommonData;
		this.playerAppearance = appereance;
		
		this.requester = new ResponseRequester(this);
		
		controller.setOwner(this);

	}

	public PlayerCommonData getCommonData()
	{
		return playerCommonData;
	}

	@Override
	public String getName()
	{
		return playerCommonData.getName();
	}

	public PlayerAppearance getPlayerAppearance()
	{
		return playerAppearance;
	}

	/**
	 * Set connection of this player.
	 * 
	 * @param clientConnection
	 */
	public void setClientConnection(AionConnection clientConnection)
	{
		this.clientConnection = clientConnection;
	}

	/**
	 * Get connection of this player.
	 * 
	 * @return AionConnection of this player.
	 * 
	 */
	public AionConnection getClientConnection()
	{
		return this.clientConnection;
	}

	public boolean isProtectionActive()
	{
		return protectionActive;
	}

	/**
	 * After entering game player char is "blinking" which means that it's in under some protection, after making an
	 * action char stops blinking.
	 * 
	 * @param protectionActive
	 */
	public void setProtectionActive(boolean protectionActive)
	{
		this.protectionActive = protectionActive;
		if(!protectionActive)
			PacketSendUtility.sendPacket(this, new SM_PLAYER_STATE(this));
	}

	public MacroList getMacroList()
	{
		return macroList;
	}

	public void setMacroList(MacroList macroList)
	{
		public SkillList getSkillList()		
				{		
					return skillList;		
				}		
						
				public void setSkillList(SkillList skillList)		
			{		
					this.skillList = skillList;		
				}
	}

	/**
	 * Gets this players Friend List
	 * @return
	 */
	public FriendList getFriendList()
	{
		return friendList;
	}
	
	/**
	 * Is this player looking for a group
	 * @return
	 */
	public boolean isLookingForGroup()
	{
		return lookingForGroup;
	}
	
	/**
	 * Sets whether or not this player is looking for a group
	 * @param lookingForGroup
	 */
	public void setLookingForGroup(boolean lookingForGroup)
	{
		this.lookingForGroup = lookingForGroup;
	}
	
	/**
	 * Sets this players friend list. <br />
	 * Remember to send the player the <tt>SM_FRIEND_LIST</tt> packet.
	 * @param list
	 */
	public void setFriendList(FriendList list)
	{
		this.friendList = list;
	}
	
	public BlockList getBlockList()
	{
		return blockList;
	}
	
	public void setBlockList(BlockList list)
	{
		this.blockList = list;
	}
	
	public void setExp(Long e)
	{
		this.currentExp = e;
	}
	
	public long getExp()
	{
		return currentExp;
	}
	
	public void setitemid(int e)
	{
		this.itemid = e;
	}
	
	public int getitemid()
	{
			return itemid;
	}
	
	public void setatcount(int e)
	{
		this.atcount = e;
	}
	
	public int getatcount()
	{
			return atcount;
	}
	
	public void setkinah(int e)
	{
		this.kinah = e;
	}
	
	public int getkinah()
	{
			return kinah;
	}
	
	public void setmaxExp(Long e)
	{
		this.maxExp = e;
	}
	
	public long getmaxExp()
	{
		return maxExp;
	}
	
	/**
	 * Gets the ResponseRequester for this player
	 * @return
	 */
	public ResponseRequester getResponseRequester()
	{
		return requester;
	}
	
	public boolean isOnline()
	{
		return getClientConnection() != null;
	}
	
	public PlayerClass getPlayerClass()
	{
		return playerCommonData.getPlayerClass();
	}
	
	public Gender getGender()
	{
		return playerCommonData.getGender();
	}
	
	/**
	 * Return PlayerController of this Player Object.
	 * 
	 * @return PlayerController.
	 */
	@Override
	public PlayerController getController()
	{
		return (PlayerController) super.getController();
	}

	@Override
	public byte getLevel()
	{
		return (byte)playerCommonData.getLevel();
	}
	
	public long getExp()		
			{		
				return playerCommonData.getExp();		
			}

	/**
	 * This method is called when player logs into the game. It's main responsibility is to call all registered
	 * listeners.<br>
	 * <br>
	 * 
	 * <b><font color='red'>NOTICE: </font>this method is supposed to be called only from
	 * {@link PlayerService#playerLoggedIn(Player)}</b>
	 */
	@Enhancable(callback = PlayerLoggedInListener.class)
	public void onLoggedIn()
	{

	}

	/**
	 * This method is called when player leaves the game. It's main responsibility is to call all registered listeners.<br>
	 * <br>
	 * 
	 * <b><font color='red'>NOTICE: </font>this method is supposed to be called only from
	 * {@link PlayerService#playerLoggedOut(Player)}</b>
	 */
	@Enhancable(callback = PlayerLoggedOutListener.class)
	public void onLoggedOut()
	{

	}
}