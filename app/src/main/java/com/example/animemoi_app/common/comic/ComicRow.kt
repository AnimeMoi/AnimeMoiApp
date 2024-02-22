package com.example.animemoi_app.common.comic

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun ComicRow() {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(10.dp), contentPadding = PaddingValues(8.dp)
    ) {
        item {
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Test",
                star = 3.3f,
                views = 50,
                follow = 60
            )
            Comic(
                imageUrl = "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Test2",
                views = 1,
                follow = 60
            )
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Test3",
                views = 503,
                follow = 6
            )
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Test5",
            )
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Tes4",
            )
        }
    }
}