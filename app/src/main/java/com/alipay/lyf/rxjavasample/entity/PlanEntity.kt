package com.alipay.lyf.rxjavasample.entity

/**
 * Created by 01F on 2017/6/10.
 */
data class PlanDetailEntity(val title:String,val readimg:String)

data class PageListEntity(val pagelist:PageEntity<PlanDetailEntity>)