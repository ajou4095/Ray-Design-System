package com.ray.rds.common.color

import android.content.Context
import com.ray.rds.R

sealed interface ColorType {
    object Red : ColorType
    object Pink : ColorType
    object Purple : ColorType
    object Blue : ColorType
    object Cyan : ColorType
    object Green : ColorType
    object Yellow : ColorType
    object Orange : ColorType
    object Brown : ColorType
    object BlueGray : ColorType
    object Gray : ColorType

    fun getColorSet(context: Context): ColorSet {
        return Companion.getColorSet(context, this)
    }

    companion object {
        // TODO : attrs 와 index 연결짓기
        fun getColorTypeByIndex(index: Int): ColorType? = when (index) {
            0 -> Red
            1 -> Pink
            2 -> Purple
            3 -> Blue
            4 -> Cyan
            5 -> Green
            6 -> Yellow
            7 -> Orange
            8 -> Brown
            9 -> BlueGray
            10 -> Gray
            else -> null
        }

        fun getColorSet(context: Context, colorType: ColorType): ColorSet = when (colorType) {
            Red -> ColorSet(
                bg100 = context.getColor(R.color.bg_red_100),
                bg200 = context.getColor(R.color.bg_red_200),
                bg300 = context.getColor(R.color.bg_red_300),
                bg400 = context.getColor(R.color.bg_red_400),
                bg500 = context.getColor(R.color.bg_red_500),
                bg600 = context.getColor(R.color.bg_red_600),
                bg700 = context.getColor(R.color.bg_red_700),
                bg800 = context.getColor(R.color.bg_red_800),
                bg900 = context.getColor(R.color.bg_red_900),
                fg100 = context.getColor(R.color.fg_red_100),
                fg200 = context.getColor(R.color.fg_red_200),
                fg300 = context.getColor(R.color.fg_red_300),
                fg400 = context.getColor(R.color.fg_red_400),
                fg500 = context.getColor(R.color.fg_red_500),
                fg600 = context.getColor(R.color.fg_red_600),
                fg700 = context.getColor(R.color.fg_red_700),
                fg800 = context.getColor(R.color.fg_red_800),
                fg900 = context.getColor(R.color.fg_red_900)
            )

            Pink -> ColorSet(
                bg100 = context.getColor(R.color.bg_pink_100),
                bg200 = context.getColor(R.color.bg_pink_200),
                bg300 = context.getColor(R.color.bg_pink_300),
                bg400 = context.getColor(R.color.bg_pink_400),
                bg500 = context.getColor(R.color.bg_pink_500),
                bg600 = context.getColor(R.color.bg_pink_600),
                bg700 = context.getColor(R.color.bg_pink_700),
                bg800 = context.getColor(R.color.bg_pink_800),
                bg900 = context.getColor(R.color.bg_pink_900),
                fg100 = context.getColor(R.color.fg_pink_100),
                fg200 = context.getColor(R.color.fg_pink_200),
                fg300 = context.getColor(R.color.fg_pink_300),
                fg400 = context.getColor(R.color.fg_pink_400),
                fg500 = context.getColor(R.color.fg_pink_500),
                fg600 = context.getColor(R.color.fg_pink_600),
                fg700 = context.getColor(R.color.fg_pink_700),
                fg800 = context.getColor(R.color.fg_pink_800),
                fg900 = context.getColor(R.color.fg_pink_900)
            )

            Purple -> ColorSet(
                bg100 = context.getColor(R.color.bg_purple_100),
                bg200 = context.getColor(R.color.bg_purple_200),
                bg300 = context.getColor(R.color.bg_purple_300),
                bg400 = context.getColor(R.color.bg_purple_400),
                bg500 = context.getColor(R.color.bg_purple_500),
                bg600 = context.getColor(R.color.bg_purple_600),
                bg700 = context.getColor(R.color.bg_purple_700),
                bg800 = context.getColor(R.color.bg_purple_800),
                bg900 = context.getColor(R.color.bg_purple_900),
                fg100 = context.getColor(R.color.fg_purple_100),
                fg200 = context.getColor(R.color.fg_purple_200),
                fg300 = context.getColor(R.color.fg_purple_300),
                fg400 = context.getColor(R.color.fg_purple_400),
                fg500 = context.getColor(R.color.fg_purple_500),
                fg600 = context.getColor(R.color.fg_purple_600),
                fg700 = context.getColor(R.color.fg_purple_700),
                fg800 = context.getColor(R.color.fg_purple_800),
                fg900 = context.getColor(R.color.fg_purple_900)
            )

            Blue -> ColorSet(
                bg100 = context.getColor(R.color.bg_blue_100),
                bg200 = context.getColor(R.color.bg_blue_200),
                bg300 = context.getColor(R.color.bg_blue_300),
                bg400 = context.getColor(R.color.bg_blue_400),
                bg500 = context.getColor(R.color.bg_blue_500),
                bg600 = context.getColor(R.color.bg_blue_600),
                bg700 = context.getColor(R.color.bg_blue_700),
                bg800 = context.getColor(R.color.bg_blue_800),
                bg900 = context.getColor(R.color.bg_blue_900),
                fg100 = context.getColor(R.color.fg_blue_100),
                fg200 = context.getColor(R.color.fg_blue_200),
                fg300 = context.getColor(R.color.fg_blue_300),
                fg400 = context.getColor(R.color.fg_blue_400),
                fg500 = context.getColor(R.color.fg_blue_500),
                fg600 = context.getColor(R.color.fg_blue_600),
                fg700 = context.getColor(R.color.fg_blue_700),
                fg800 = context.getColor(R.color.fg_blue_800),
                fg900 = context.getColor(R.color.fg_blue_900)
            )

            Cyan -> ColorSet(
                bg100 = context.getColor(R.color.bg_cyan_100),
                bg200 = context.getColor(R.color.bg_cyan_200),
                bg300 = context.getColor(R.color.bg_cyan_300),
                bg400 = context.getColor(R.color.bg_cyan_400),
                bg500 = context.getColor(R.color.bg_cyan_500),
                bg600 = context.getColor(R.color.bg_cyan_600),
                bg700 = context.getColor(R.color.bg_cyan_700),
                bg800 = context.getColor(R.color.bg_cyan_800),
                bg900 = context.getColor(R.color.bg_cyan_900),
                fg100 = context.getColor(R.color.fg_cyan_100),
                fg200 = context.getColor(R.color.fg_cyan_200),
                fg300 = context.getColor(R.color.fg_cyan_300),
                fg400 = context.getColor(R.color.fg_cyan_400),
                fg500 = context.getColor(R.color.fg_cyan_500),
                fg600 = context.getColor(R.color.fg_cyan_600),
                fg700 = context.getColor(R.color.fg_cyan_700),
                fg800 = context.getColor(R.color.fg_cyan_800),
                fg900 = context.getColor(R.color.fg_cyan_900)
            )

            Green -> ColorSet(
                bg100 = context.getColor(R.color.bg_green_100),
                bg200 = context.getColor(R.color.bg_green_200),
                bg300 = context.getColor(R.color.bg_green_300),
                bg400 = context.getColor(R.color.bg_green_400),
                bg500 = context.getColor(R.color.bg_green_500),
                bg600 = context.getColor(R.color.bg_green_600),
                bg700 = context.getColor(R.color.bg_green_700),
                bg800 = context.getColor(R.color.bg_green_800),
                bg900 = context.getColor(R.color.bg_green_900),
                fg100 = context.getColor(R.color.fg_green_100),
                fg200 = context.getColor(R.color.fg_green_200),
                fg300 = context.getColor(R.color.fg_green_300),
                fg400 = context.getColor(R.color.fg_green_400),
                fg500 = context.getColor(R.color.fg_green_500),
                fg600 = context.getColor(R.color.fg_green_600),
                fg700 = context.getColor(R.color.fg_green_700),
                fg800 = context.getColor(R.color.fg_green_800),
                fg900 = context.getColor(R.color.fg_green_900)
            )

            Yellow -> ColorSet(
                bg100 = context.getColor(R.color.bg_yellow_100),
                bg200 = context.getColor(R.color.bg_yellow_200),
                bg300 = context.getColor(R.color.bg_yellow_300),
                bg400 = context.getColor(R.color.bg_yellow_400),
                bg500 = context.getColor(R.color.bg_yellow_500),
                bg600 = context.getColor(R.color.bg_yellow_600),
                bg700 = context.getColor(R.color.bg_yellow_700),
                bg800 = context.getColor(R.color.bg_yellow_800),
                bg900 = context.getColor(R.color.bg_yellow_900),
                fg100 = context.getColor(R.color.fg_yellow_100),
                fg200 = context.getColor(R.color.fg_yellow_200),
                fg300 = context.getColor(R.color.fg_yellow_300),
                fg400 = context.getColor(R.color.fg_yellow_400),
                fg500 = context.getColor(R.color.fg_yellow_500),
                fg600 = context.getColor(R.color.fg_yellow_600),
                fg700 = context.getColor(R.color.fg_yellow_700),
                fg800 = context.getColor(R.color.fg_yellow_800),
                fg900 = context.getColor(R.color.fg_yellow_900)
            )

            Orange -> ColorSet(
                bg100 = context.getColor(R.color.bg_orange_100),
                bg200 = context.getColor(R.color.bg_orange_200),
                bg300 = context.getColor(R.color.bg_orange_300),
                bg400 = context.getColor(R.color.bg_orange_400),
                bg500 = context.getColor(R.color.bg_orange_500),
                bg600 = context.getColor(R.color.bg_orange_600),
                bg700 = context.getColor(R.color.bg_orange_700),
                bg800 = context.getColor(R.color.bg_orange_800),
                bg900 = context.getColor(R.color.bg_orange_900),
                fg100 = context.getColor(R.color.fg_orange_100),
                fg200 = context.getColor(R.color.fg_orange_200),
                fg300 = context.getColor(R.color.fg_orange_300),
                fg400 = context.getColor(R.color.fg_orange_400),
                fg500 = context.getColor(R.color.fg_orange_500),
                fg600 = context.getColor(R.color.fg_orange_600),
                fg700 = context.getColor(R.color.fg_orange_700),
                fg800 = context.getColor(R.color.fg_orange_800),
                fg900 = context.getColor(R.color.fg_orange_900)
            )

            Brown -> ColorSet(
                bg100 = context.getColor(R.color.bg_brown_100),
                bg200 = context.getColor(R.color.bg_brown_200),
                bg300 = context.getColor(R.color.bg_brown_300),
                bg400 = context.getColor(R.color.bg_brown_400),
                bg500 = context.getColor(R.color.bg_brown_500),
                bg600 = context.getColor(R.color.bg_brown_600),
                bg700 = context.getColor(R.color.bg_brown_700),
                bg800 = context.getColor(R.color.bg_brown_800),
                bg900 = context.getColor(R.color.bg_brown_900),
                fg100 = context.getColor(R.color.fg_brown_100),
                fg200 = context.getColor(R.color.fg_brown_200),
                fg300 = context.getColor(R.color.fg_brown_300),
                fg400 = context.getColor(R.color.fg_brown_400),
                fg500 = context.getColor(R.color.fg_brown_500),
                fg600 = context.getColor(R.color.fg_brown_600),
                fg700 = context.getColor(R.color.fg_brown_700),
                fg800 = context.getColor(R.color.fg_brown_800),
                fg900 = context.getColor(R.color.fg_brown_900)
            )

            BlueGray -> ColorSet(
                bg100 = context.getColor(R.color.bg_blue_gray_100),
                bg200 = context.getColor(R.color.bg_blue_gray_200),
                bg300 = context.getColor(R.color.bg_blue_gray_300),
                bg400 = context.getColor(R.color.bg_blue_gray_400),
                bg500 = context.getColor(R.color.bg_blue_gray_500),
                bg600 = context.getColor(R.color.bg_blue_gray_600),
                bg700 = context.getColor(R.color.bg_blue_gray_700),
                bg800 = context.getColor(R.color.bg_blue_gray_800),
                bg900 = context.getColor(R.color.bg_blue_gray_900),
                fg100 = context.getColor(R.color.fg_blue_gray_100),
                fg200 = context.getColor(R.color.fg_blue_gray_200),
                fg300 = context.getColor(R.color.fg_blue_gray_300),
                fg400 = context.getColor(R.color.fg_blue_gray_400),
                fg500 = context.getColor(R.color.fg_blue_gray_500),
                fg600 = context.getColor(R.color.fg_blue_gray_600),
                fg700 = context.getColor(R.color.fg_blue_gray_700),
                fg800 = context.getColor(R.color.fg_blue_gray_800),
                fg900 = context.getColor(R.color.fg_blue_gray_900)
            )

            Gray -> ColorSet(
                bg100 = context.getColor(R.color.bg_gray_100),
                bg200 = context.getColor(R.color.bg_gray_200),
                bg300 = context.getColor(R.color.bg_gray_300),
                bg400 = context.getColor(R.color.bg_gray_400),
                bg500 = context.getColor(R.color.bg_gray_500),
                bg600 = context.getColor(R.color.bg_gray_600),
                bg700 = context.getColor(R.color.bg_gray_700),
                bg800 = context.getColor(R.color.bg_gray_800),
                bg900 = context.getColor(R.color.bg_gray_900),
                fg100 = context.getColor(R.color.fg_gray_100),
                fg200 = context.getColor(R.color.fg_gray_200),
                fg300 = context.getColor(R.color.fg_gray_300),
                fg400 = context.getColor(R.color.fg_gray_400),
                fg500 = context.getColor(R.color.fg_gray_500),
                fg600 = context.getColor(R.color.fg_gray_600),
                fg700 = context.getColor(R.color.fg_gray_700),
                fg800 = context.getColor(R.color.fg_gray_800),
                fg900 = context.getColor(R.color.fg_gray_900)
            )
        }
    }
}

