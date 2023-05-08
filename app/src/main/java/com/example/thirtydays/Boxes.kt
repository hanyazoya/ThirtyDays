package com.example.thirtydays

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Box (
    @DrawableRes val imageRes: Int,
    val nameRes: String,
    val descriptionRes: String
)

class Boxes {
    val typesOfBoxes = listOf (
        Box(
            imageRes = R.drawable.bulk_cargo,
            nameRes = "Bulk Cargo",
            descriptionRes = "Bulk cargo containers hold and organize large quantities of items. They are measured with outside dimensions for matching to pallet sizes. These large boxes consolidate and transfer large shipments that need to stay together from one location to another."
        ),
        Box(
            imageRes = R.drawable.corrugated_pads,
            nameRes = "Corrugated Pads",
            descriptionRes = "Corrugated pads and sheets are flat pieces of cardboard or plastic that layer between products or separate items in a palletized stack. Pads and sheets also protect the floor beneath a pallet. They can also be cut and formed into custom-sized boxes."
        ),
        Box(
            imageRes = R.drawable.easy_fold_mailers,
            nameRes = "Easy-Fold Mailers",
            descriptionRes = "Easy-fold mailer boxes are one-piece mailers that fit multiple sizes and colors for any sort of package. They are great for any books, catalogs, and framed pictures. They are scored at multiple depths with an adaptive fit to suit any product."
        ),
        Box(
            imageRes = R.drawable.ect_lightweight,
            nameRes = "32 ECT Lightweight",
            descriptionRes = "Budget friendly for storing and shipping lightweight products. Ideal for toys, towels, and other durable items. 200-lb test. 32 ECT."
        ),
        Box(
            imageRes = R.drawable.multi_depth,
            nameRes = "Multi-Depth",
            descriptionRes = "A time and space-saving solution, multi-depth boxes allow you to effectively stock several double wall cardboard box sizes in minimum storage space."
        ),
        Box(
            imageRes = R.drawable.storage_file,
            nameRes = "Storage File",
            descriptionRes = "Storage file boxes are specifically designed to store archived files. They come in typical sized of paper documents in that region"
        ),
        Box(
            imageRes = R.drawable.moving_boxes,
            nameRes = "Moving Boxes",
            descriptionRes = "Storage boxes are great for transporting your items, but it's important to note that customized storage boxes a.k.a. moving boxes can help fasten your packing journey."
        ),
        Box(
            imageRes = R.drawable.side_loaders,
            nameRes = "Side Loaders",
            descriptionRes = "Side loaders boxes are used to easily load flat or narrow items like frames, mirrors and more from the side."
        ),
        Box(
            imageRes = R.drawable.hazmat_boxes,
            nameRes = "Hazmat",
            descriptionRes = "Hazmat boxes are personalized for securing important emergency information including the manifest of hazardous chemicals, safety data sheets (SDSs), and site emergency plans."
        ),
        Box(
            imageRes = R.drawable.wine_shippers,
            nameRes = "Wine Shippers",
            descriptionRes = "Wine shipping boxes are boxes in the size of wine or champagne bottles. They may have some inserts to hold the bottle shapes inside the box."
        ),
        Box(
            imageRes = R.drawable.insulated_shippers,
            nameRes = "Insulated Shippers",
            descriptionRes = "Insulated shippers are ideal to keep your frozen food fresh with cold pack inside. They usually come hand in hand with foam coolers, box liners, bubble rolls and more."
        ),
        Box(
            imageRes = R.drawable.wood_crates,
            nameRes = "Wood Crates",
            descriptionRes = "A crate is a large shipping container, often made of wood, typically used to transport or store large, heavy items."
        )
    )
}