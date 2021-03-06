package com.achmadqomarudin.licensemanager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import net.yslibrary.licenseadapter.LicenseAdapter;
import net.yslibrary.licenseadapter.LicenseEntry;
import net.yslibrary.licenseadapter.Licenses;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<LicenseEntry> licences = new ArrayList<>();

        // Libraries that are not hosted on GitHub
        licences.add(Licenses.noContent("Android SDK", "Google Inc.", "https://developer.android.com/sdk/terms.html"));
        licences.add(Licenses.noContent("Android Support Libraries", "Google Inc.", "https://developer.android.com/sdk/terms.html"));
        licences.add(Licenses.noContent("Mosque Vector Icon", "Freepik", "https://www.flaticon.com"));

        // Libraries that are hosted on GitHub, but do not provide license text
        licences.add(Licenses.fromGitHub("Kennyc1012/MultiStateView", Licenses.LICENSE_APACHE_V2));

        // Libraries that are hosted on GitHub, and "LICENSE.md" is provided
        licences.add(Licenses.fromGitHub("mehmetakiftutuncu/Toolbelt", Licenses.FILE_MD));

        // Libraries that are hosted on GitHub, and "LICENSE.txt" is provided
        licences.add(Licenses.fromGitHub("arimorty/floatingsearchview"));
        licences.add(Licenses.fromGitHub("stephentuso/welcome-android"));
        licences.add(Licenses.fromGitHub("square/okhttp"));
        licences.add(Licenses.fromGitHub("JodaOrg/joda-time"));

        // Libraries that are hosted on GitHub, and license file is provided as "LICENSE"
        licences.add(Licenses.fromGitHub("Maddoc42/Android-Material-Icon-Generator", Licenses.FILE_NO_EXTENSION));
        licences.add(Licenses.fromGitHub("yshrsmz/LicenseAdapter", Licenses.FILE_NO_EXTENSION));
        licences.add(Licenses.fromGitHub("makiftutuncu/Muezzin", Licenses.NAME_MIT));
        licences.add(Licenses.fromGitHub("yshrsmz/LicenseAdapter", Licenses.NAME_APACHE_V2));

        LicenseAdapter adapter = new LicenseAdapter(licences);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        RecyclerView recyclerView = findViewById(R.id.recyclerView_licences);

        if (recyclerView != null) {
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);

            Licenses.load(licences);
        }
    }
}
