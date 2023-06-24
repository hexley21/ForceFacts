package org.hxl.discover.menu.starship

import dagger.hilt.android.lifecycle.HiltViewModel
import org.hxl.discover.menu.base.BaseListViewModel
import org.hxl.domain.usecase.starship.StarShipUseCase
import org.hxl.model.StarShip
import javax.inject.Inject

@HiltViewModel
class StarShipListViewModel @Inject constructor(getStarShip: StarShipUseCase):
    BaseListViewModel<StarShip>(getStarShip::searchStarShips)