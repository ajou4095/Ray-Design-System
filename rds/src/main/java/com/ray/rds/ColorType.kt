package com.ray.rds

sealed class ColorType(val colorSet: ColorSet) {
    object Red : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xFFEBEE,
            variant100 = -0x1000000 or 0xFFCDD2,
            variant200 = -0x1000000 or 0xEF9A9A,
            variant300 = -0x1000000 or 0xE57373,
            variant400 = -0x1000000 or 0xEF5350,
            variant500 = -0x1000000 or 0xF44336,
            variant600 = -0x1000000 or 0xE53935,
            variant700 = -0x1000000 or 0xD32F2F,
            variant800 = -0x1000000 or 0xC62828,
            variant900 = -0x1000000 or 0xB71C1C
        )
    )

    object Pink : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xFCE4EC,
            variant100 = -0x1000000 or 0xF8BBD0,
            variant200 = -0x1000000 or 0xF48FB1,
            variant300 = -0x1000000 or 0xF06292,
            variant400 = -0x1000000 or 0xEC407A,
            variant500 = -0x1000000 or 0xE91E63,
            variant600 = -0x1000000 or 0xD81B60,
            variant700 = -0x1000000 or 0xC2185B,
            variant800 = -0x1000000 or 0xAD1457,
            variant900 = -0x1000000 or 0x880E4F
        )
    )

    object Purple : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xF3E5F5,
            variant100 = -0x1000000 or 0xE1BEE7,
            variant200 = -0x1000000 or 0xCE93D8,
            variant300 = -0x1000000 or 0xBA68C8,
            variant400 = -0x1000000 or 0xAB47BC,
            variant500 = -0x1000000 or 0x9C27B0,
            variant600 = -0x1000000 or 0x8E24AA,
            variant700 = -0x1000000 or 0x7B1FA2,
            variant800 = -0x1000000 or 0x6A1B9A,
            variant900 = -0x1000000 or 0x4A148C
        )
    )

    object DeepPurple : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xEDE7F6,
            variant100 = -0x1000000 or 0xD1C4E9,
            variant200 = -0x1000000 or 0xB39DDB,
            variant300 = -0x1000000 or 0x9575CD,
            variant400 = -0x1000000 or 0x7E57C2,
            variant500 = -0x1000000 or 0x673AB7,
            variant600 = -0x1000000 or 0x5E35B1,
            variant700 = -0x1000000 or 0x512DA8,
            variant800 = -0x1000000 or 0x4527A0,
            variant900 = -0x1000000 or 0x311B92
        )
    )

    object Indigo : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xE8EAF6,
            variant100 = -0x1000000 or 0xC5CAE9,
            variant200 = -0x1000000 or 0x9FA8DA,
            variant300 = -0x1000000 or 0x7986CB,
            variant400 = -0x1000000 or 0x5C6BC0,
            variant500 = -0x1000000 or 0x3F51B5,
            variant600 = -0x1000000 or 0x3949AB,
            variant700 = -0x1000000 or 0x303F9F,
            variant800 = -0x1000000 or 0x283593,
            variant900 = -0x1000000 or 0x1A237E
        )
    )

    object Blue : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xE3F2FD,
            variant100 = -0x1000000 or 0xBBDEFB,
            variant200 = -0x1000000 or 0x90CAF9,
            variant300 = -0x1000000 or 0x64B5F6,
            variant400 = -0x1000000 or 0x42A5F5,
            variant500 = -0x1000000 or 0x2196F3,
            variant600 = -0x1000000 or 0x1E88E5,
            variant700 = -0x1000000 or 0x1976D2,
            variant800 = -0x1000000 or 0x1565C0,
            variant900 = -0x1000000 or 0x0D47A1
        )
    )

    object LightBlue : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xE1F5FE,
            variant100 = -0x1000000 or 0xB3E5FC,
            variant200 = -0x1000000 or 0x81D4fA,
            variant300 = -0x1000000 or 0x4fC3F7,
            variant400 = -0x1000000 or 0x29B6FC,
            variant500 = -0x1000000 or 0x03A9F4,
            variant600 = -0x1000000 or 0x039BE5,
            variant700 = -0x1000000 or 0x0288D1,
            variant800 = -0x1000000 or 0x0277BD,
            variant900 = -0x1000000 or 0x01579B
        )
    )

    object Cyan : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xE0F7FA,
            variant100 = -0x1000000 or 0xB2EBF2,
            variant200 = -0x1000000 or 0x80DEEA,
            variant300 = -0x1000000 or 0x4DD0E1,
            variant400 = -0x1000000 or 0x26C6DA,
            variant500 = -0x1000000 or 0x00BCD4,
            variant600 = -0x1000000 or 0x00ACC1,
            variant700 = -0x1000000 or 0x0097A7,
            variant800 = -0x1000000 or 0x00838F,
            variant900 = -0x1000000 or 0x006064
        )
    )

    object Teal : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xE0F2F1,
            variant100 = -0x1000000 or 0xB2DFDB,
            variant200 = -0x1000000 or 0x80CBC4,
            variant300 = -0x1000000 or 0x4DB6AC,
            variant400 = -0x1000000 or 0x26A69A,
            variant500 = -0x1000000 or 0x009688,
            variant600 = -0x1000000 or 0x00897B,
            variant700 = -0x1000000 or 0x00796B,
            variant800 = -0x1000000 or 0x00695C,
            variant900 = -0x1000000 or 0x004D40
        )
    )

    object Green : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xE8F5E9,
            variant100 = -0x1000000 or 0xC8E6C9,
            variant200 = -0x1000000 or 0xA5D6A7,
            variant300 = -0x1000000 or 0x81C784,
            variant400 = -0x1000000 or 0x66BB6A,
            variant500 = -0x1000000 or 0x4CAF50,
            variant600 = -0x1000000 or 0x43A047,
            variant700 = -0x1000000 or 0x388E3C,
            variant800 = -0x1000000 or 0x2E7D32,
            variant900 = -0x1000000 or 0x1B5E20
        )
    )

    object LightGreen : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xF1F8E9,
            variant100 = -0x1000000 or 0xDCEDC8,
            variant200 = -0x1000000 or 0xC5E1A5,
            variant300 = -0x1000000 or 0xAED581,
            variant400 = -0x1000000 or 0x9CCC65,
            variant500 = -0x1000000 or 0x8BC34A,
            variant600 = -0x1000000 or 0x7CB342,
            variant700 = -0x1000000 or 0x689F38,
            variant800 = -0x1000000 or 0x558B2F,
            variant900 = -0x1000000 or 0x33691E
        )
    )

    object Lime : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xF9FBE7,
            variant100 = -0x1000000 or 0xF0F4C3,
            variant200 = -0x1000000 or 0xE6EE9C,
            variant300 = -0x1000000 or 0xDCE775,
            variant400 = -0x1000000 or 0xD4E157,
            variant500 = -0x1000000 or 0xCDDC39,
            variant600 = -0x1000000 or 0xC0CA33,
            variant700 = -0x1000000 or 0xA4B42B,
            variant800 = -0x1000000 or 0x9E9D24,
            variant900 = -0x1000000 or 0x827717
        )
    )

    object Yellow : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xFFFDE7,
            variant100 = -0x1000000 or 0xFFF9C4,
            variant200 = -0x1000000 or 0xFFF590,
            variant300 = -0x1000000 or 0xFFF176,
            variant400 = -0x1000000 or 0xFFEE58,
            variant500 = -0x1000000 or 0xFFEB3B,
            variant600 = -0x1000000 or 0xFDD835,
            variant700 = -0x1000000 or 0xFBC02D,
            variant800 = -0x1000000 or 0xF9A825,
            variant900 = -0x1000000 or 0xF57F17
        )
    )

    object Amber : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xFFF8E1,
            variant100 = -0x1000000 or 0xFFECB3,
            variant200 = -0x1000000 or 0xFFE082,
            variant300 = -0x1000000 or 0xFFD54F,
            variant400 = -0x1000000 or 0xFFCA28,
            variant500 = -0x1000000 or 0xFFC107,
            variant600 = -0x1000000 or 0xFFB300,
            variant700 = -0x1000000 or 0xFFA000,
            variant800 = -0x1000000 or 0xFF8F00,
            variant900 = -0x1000000 or 0xFF6F00
        )
    )

    object Orange : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xFFF3E0,
            variant100 = -0x1000000 or 0xFFE0B2,
            variant200 = -0x1000000 or 0xFFCC80,
            variant300 = -0x1000000 or 0xFFB74D,
            variant400 = -0x1000000 or 0xFFA726,
            variant500 = -0x1000000 or 0xFF9800,
            variant600 = -0x1000000 or 0xFB8C00,
            variant700 = -0x1000000 or 0xF57C00,
            variant800 = -0x1000000 or 0xEF6C00,
            variant900 = -0x1000000 or 0xE65100
        )
    )

    object DeepOrange : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xFBE9A7,
            variant100 = -0x1000000 or 0xFFCCBC,
            variant200 = -0x1000000 or 0xFFAB91,
            variant300 = -0x1000000 or 0xFF8A65,
            variant400 = -0x1000000 or 0xFF7043,
            variant500 = -0x1000000 or 0xFF5722,
            variant600 = -0x1000000 or 0xF4511E,
            variant700 = -0x1000000 or 0xE64A19,
            variant800 = -0x1000000 or 0xD84315,
            variant900 = -0x1000000 or 0xBF360C
        )
    )

    object Brown : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xEFEBE9,
            variant100 = -0x1000000 or 0xD7CCC8,
            variant200 = -0x1000000 or 0xBCAAA4,
            variant300 = -0x1000000 or 0xA1887F,
            variant400 = -0x1000000 or 0x8D6E63,
            variant500 = -0x1000000 or 0x795548,
            variant600 = -0x1000000 or 0x6D4C41,
            variant700 = -0x1000000 or 0x5D4037,
            variant800 = -0x1000000 or 0x4E342E,
            variant900 = -0x1000000 or 0x3E2723
        )
    )

    object Gray : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xFAFAFA,
            variant100 = -0x1000000 or 0xF5F5F5,
            variant200 = -0x1000000 or 0xEEEEEE,
            variant300 = -0x1000000 or 0xE0E0E0,
            variant400 = -0x1000000 or 0xBDBDBD,
            variant500 = -0x1000000 or 0x9E9E9E,
            variant600 = -0x1000000 or 0x757575,
            variant700 = -0x1000000 or 0x616161,
            variant800 = -0x1000000 or 0x424242,
            variant900 = -0x1000000 or 0x212121
        )
    )

    object BlueGray : ColorType(
        ColorSet(
            variant50 = -0x1000000 or 0xECEFF1,
            variant100 = -0x1000000 or 0xCFD8DC,
            variant200 = -0x1000000 or 0xB0BBC5,
            variant300 = -0x1000000 or 0x90A4AE,
            variant400 = -0x1000000 or 0x78909C,
            variant500 = -0x1000000 or 0x607D8B,
            variant600 = -0x1000000 or 0x546E7A,
            variant700 = -0x1000000 or 0x455A64,
            variant800 = -0x1000000 or 0x37474F,
            variant900 = -0x1000000 or 0x263238
        )
    )

    companion object {
        // TODO : attrs 와 index 연결짓기
        fun getColorTypeByIndex(index: Int): ColorType? = when (index) {
            0 -> Red
            1 -> Pink
            2 -> Purple
            3 -> DeepPurple
            4 -> Indigo
            5 -> Blue
            6 -> LightBlue
            7 -> Cyan
            8 -> Teal
            9 -> Green
            10 -> LightGreen
            11 -> Lime
            12 -> Yellow
            13 -> Amber
            14 -> Orange
            15 -> DeepOrange
            16 -> Brown
            17 -> Gray
            18 -> BlueGray
            else -> null
        }
    }
}

data class ColorSet(
    val variant50: Int,
    val variant100: Int,
    val variant200: Int,
    val variant300: Int,
    val variant400: Int,
    val variant500: Int,
    val variant600: Int,
    val variant700: Int,
    val variant800: Int,
    val variant900: Int
)