--[[message 同调召唤入门]]
Debug.SetAIName("高性能电子头脑")
Debug.ReloadFieldBegin(DUEL_ATTACK_FIRST_TURN+DUEL_SIMPLE_AI,5)
Debug.SetPlayerInfo(0,8000,0,0)
Debug.SetPlayerInfo(1,3100,0,0)

Debug.AddCard(00027551,0,0,LOCATION_SZONE,2,POS_FACEDOWN)

Debug.AddCard(34100324,0,0,LOCATION_GRAVE,0,POS_FACEUP_ATTACK)

Debug.AddCard(83764718,0,0,LOCATION_HAND,0,POS_FACEDOWN)
Debug.AddCard(96363153,0,0,LOCATION_HAND,0,POS_FACEDOWN)

Debug.AddCard(63977008,0,0,LOCATION_DECK,1,POS_FACEUP_ATTACK)
Debug.AddCard(40348946,0,0,LOCATION_DECK,2,POS_FACEUP_ATTACK)

Debug.AddCard(68124775,0,0,LOCATION_EXTRA,0,POS_FACEDOWN)
Debug.AddCard(26593852,0,0,LOCATION_EXTRA,1,POS_FACEDOWN)

Debug.AddCard(34408491,1,1,LOCATION_MZONE,2,POS_FACEUP_ATTACK)
Debug.AddCard(16527176,1,1,LOCATION_MZONE,3,POS_FACEUP_ATTACK)

Debug.ReloadFieldEnd()
Debug.ShowHint("GAME START!")
aux.BeginPuzzle()