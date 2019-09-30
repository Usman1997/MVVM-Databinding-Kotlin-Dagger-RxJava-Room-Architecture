package com.example.mvvm_databinding.utils.Schedulers

import io.reactivex.Scheduler
import org.jetbrains.annotations.NotNull

interface BaseScheduler {
    @NotNull
    fun io():Scheduler

    @NotNull
    fun ui():Scheduler
}