package audio.progress.qbx.androidaudio

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.util.Log

class NetWorkMonitor : BroadcastReceiver() {

    private val TAG = "NetWorkMonitor"

    init {
//        val connectManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
//        val netInfo = connectManager.activeNetworkInfo
//        Log.e(TAG, "" + netInfo.extraInfo)
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        System.out.println("网络状态发生变化")
        if (android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.LOLLIPOP) {

            //获得ConnectivityManager对象
            val connMgr = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as (ConnectivityManager)

            //获取ConnectivityManager对象对应的NetworkInfo对象
            //获取WIFI连接的信息
            val wifiNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
            //获取移动数据连接的信息
            val dataNetworkInfo = connMgr.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
            if (wifiNetworkInfo.isConnected() && dataNetworkInfo.isConnected()) {
                Log.e(TAG, "WIFI已连接,移动数据已连接")
            } else if (wifiNetworkInfo.isConnected() && !dataNetworkInfo.isConnected()) {
                Log.e(TAG, "WIFI已连接,移动数据已断开")
            } else if (!wifiNetworkInfo.isConnected() && dataNetworkInfo.isConnected()) {
                Log.e(TAG, "WIFI已断开,移动数据已连接")
            } else {
                Log.e(TAG, "WIFI已断开,移动数据已断开")
            }
        //API大于23时使用下面的方式进行网络监听
        } else {

            System.out.println("API level 大于23");
            //获得ConnectivityManager对象
            val connMgr = context?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

            //获取所有网络连接的信息
            val networks = connMgr.getAllNetworks();
            //用于存放网络连接信息
            val sb = StringBuilder();
            //通过循环将网络信息逐个取出来
            for (i in 0 until networks.size) {
                //获取ConnectivityManager对象对应的NetworkInfo对象
                val networkInfo = connMgr.getNetworkInfo(networks[i]);
                sb.append(networkInfo.getTypeName() + " connect is " + networkInfo.isConnected());
            }
            Log.e(TAG, sb.toString())
        }
    }
}