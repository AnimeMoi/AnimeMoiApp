package com.example.animemoi_app.common.comic

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ComicRow() {
    LazyRow(
        modifier = Modifier.padding(16.dp)
    ) {
        item {
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Truyện 1",
                star = 3.3f,
                views = 500,
                follow = 600
            )
            Spacer(modifier = Modifier.width(16.dp))
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Truyện 2",
                views = 1,
                follow = 60
            )
            Spacer(modifier = Modifier.width(16.dp))
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Truyện 3",
                views = 503,
                follow = 6
            )
            Spacer(modifier = Modifier.width(16.dp))
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Truyện 4",
            )
            Spacer(modifier = Modifier.width(16.dp))
            Comic(
                "https://www.nettruyenup.vn/images/comics/tho-san-hang-s-khong-muon-tro-thanh-ac-nu.jpg",
                moreInfo = true,
                name = "Truyện 5",
            )
        }
    }
}
