package com.example.teamapp

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.teamapp.TabFragment.Fragment1
import com.example.teamapp.TabFragment.Fragment2
import com.example.teamapp.TabFragment.Fragment3
import com.example.teamapp.TabFragment.Fragment4
import com.youth.banner.Banner
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import com.youth.banner.loader.ImageLoader
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    private val imageUrlData=ArrayList<Int>()
    private val contentData=ArrayList<String>()
    private val fragmentList=ArrayList<Fragment>()
    private val titleList=ArrayList<String>()
    private val title = arrayOf("数学竞赛", "计算机信息技术", "数学建模", "商科", "工业&创意设计")
    var mCurrentPosition=0
    private lateinit var myBanner: Banner
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initBanner()
        initTabLayout()
    }
    private fun initTabLayout(){
        viewpager.offscreenPageLimit=5
        titleList.add(title[0])
        fragmentList.add(Fragment3(title[0]))
        titleList.add(title[1])
        fragmentList.add(Fragment1(title[1]))
        titleList.add(title[2])
        fragmentList.add(Fragment2(title[2]))
        titleList.add(title[3])
        fragmentList.add(Fragment3(title[3]))
        titleList.add(title[4])
        fragmentList.add(Fragment4(title[4]))
        viewpager.adapter=ViewPagerAdapter(supportFragmentManager,fragmentList,titleList)
        tab_layout.setupWithViewPager(viewpager)
        setPager_Change(viewpager)
    }
    private fun setPager_Change(viewPager:ViewPager){
        viewPager.addOnPageChangeListener(object :ViewPager.OnPageChangeListener{
            override fun onPageScrolled(position: Int, positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                mCurrentPosition=position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })
    }
    private fun initBanner(){
        imageUrlData.add(R.drawable.match2)
        imageUrlData.add(R.drawable.match1)
        imageUrlData.add(R.drawable.match3)
        imageUrlData.add(R.drawable.match4)
        imageUrlData.add(R.drawable.match5)
        contentData.add("第二届“华数杯”全国大学生数学建模竞赛")
        contentData.add("第七届“i创杯”互联网创新创业大赛")
        contentData.add("第三届阿里巴巴全球数学竞赛")
        contentData.add("第三届粤港澳大湾区（广东）文化创意设计大赛")
        contentData.add("华为区块链高校大赛")
        myBanner= findViewById(R.id.banner)
        myBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
        myBanner.setImageLoader(MyLoader())
        myBanner.setImages(imageUrlData)
        myBanner.setBannerTitles(contentData)
        myBanner.setBannerAnimation(Transformer.Default)
        //切换频率
        myBanner.setDelayTime(4000)
        //自动启动
        myBanner.isAutoPlay(true)
        //位置设置
        myBanner.setIndicatorGravity(BannerConfig.CENTER)
        //开始运行
        myBanner.start()
    }
    private class MyLoader : ImageLoader() {
        @SuppressLint("RestrictedApi")
        override fun displayImage(context: Context?, path: Any?, imageView: ImageView?) {
            if (context != null) {
                if (imageView != null) {
                    Glide.with(context)
                        .load(path)
                        .centerCrop()
                        .into(imageView)
                }
            }
        }
    }
}