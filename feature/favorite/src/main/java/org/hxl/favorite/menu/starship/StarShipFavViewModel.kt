package org.hxl.favorite.menu.starship

import dagger.hilt.android.lifecycle.HiltViewModel
import org.hxl.domain.usecase.starship.FavoriteStarShipUseCase
import org.hxl.favorite.menu.base.BaseFavViewModel
import org.hxl.model.StarShip
import javax.inject.Inject

@HiltViewModel
class StarShipFavViewModel @Inject constructor(private val getFavorites: FavoriteStarShipUseCase):
    BaseFavViewModel<StarShip>(getFavorites::getFavoriteStarShips)