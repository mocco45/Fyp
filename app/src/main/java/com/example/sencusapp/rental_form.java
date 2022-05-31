package com.example.sencusapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.charset.StandardCharsets;

public class rental_form extends AppCompatActivity {
    //location

    TextView showLocation;
    private static final int REQUEST_LOCATION = 1;
    private LocationManager locationManager;
    String latitude, longtude;
    //drop textView
    AutoCompleteTextView autoCompleteTextView, autoCompleteTextView1, autocompleteAlbinism, autocompleteSeeing, autoCompletehearing, autoCompleteWorking, autoCompleteRemembering;
    AutoCompleteTextView autoCompleteSelfcare, autoCompleteDisability, autoCompleteMaritual, autoEducationAttainment, autoCompleteBirthcirtificate, autoCompleteEducation, autoCompleteEducationLevel;
    AutoCompleteTextView autoCompleteDeath, autoCompleteNatureDeath, autoCompleteTextnatuerdealth, childDeath, autoCompleteTextAgriculture;
    ArrayAdapter<CharSequence> adapterItems, adapterItem1, adapterAlbino, adapterSeeing, adapterHearing, adapterWorking, adapterRemembering, adapterEducationLevel;
    ArrayAdapter<CharSequence> adapterSelfcare, adapterDisability, adapterMaritual, adapterBirthcirtificate, adapterEducation, adapterEductionAttainment;
    ArrayAdapter<CharSequence> adapterDeath, adapterNatureDeath, adapterpregdeath, adapterAfterBirth, adapterAgriculture;
    String[] fred;
    Button btnSendData;
    DatabaseReference databaseReference, databaseReferenceAllperson;
    private TextInputLayout regio, distric, kat, kijij, stret;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rental_form);


        autoCompleteTextView = findViewById(R.id.auto_complete_txt);
        //connecting display layout
        adapterItems = ArrayAdapter.createFromResource(this, R.array.item_house_holder, R.layout.house_hold_layout);
        //connect with view adapter
        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setThreshold(1);

        autoCompleteTextView1 = findViewById(R.id.auto_complete_txt1);
        //connect display layout
        adapterItem1 = ArrayAdapter.createFromResource(this, R.array.item_sex, R.layout.sex_layout);
        //dislapy layer
        autoCompleteTextView1.setAdapter(adapterItem1);
///
        //connect Albinism
        autocompleteAlbinism = findViewById(R.id.auto_complete_albino);
        adapterAlbino = ArrayAdapter.createFromResource(this, R.array.item_albino, R.layout.albino_layout);
        autocompleteAlbinism.setAdapter(adapterAlbino);

        //connect layer
        autocompleteSeeing = findViewById(R.id.auto_complete_seeing);
        adapterSeeing = ArrayAdapter.createFromResource(this, R.array.item_seeing, R.layout.seeing_layout);
        autocompleteSeeing.setAdapter(adapterSeeing);

        //connect hearing
        autoCompletehearing = findViewById(R.id.auto_complete_Hearing);
        adapterHearing = ArrayAdapter.createFromResource(this, R.array.item_hearing, R.layout.hearing_layout);
        autoCompletehearing.setAdapter(adapterHearing);

        //connect Working
        autoCompleteWorking = findViewById(R.id.auto_complete_Working);
        adapterWorking = ArrayAdapter.createFromResource(this, R.array.item_working, R.layout.working_layout);
        autoCompleteWorking.setAdapter(adapterWorking);

        //connect remembering
        autoCompleteRemembering = findViewById(R.id.auto_complete_remembering);
        adapterRemembering = ArrayAdapter.createFromResource(this, R.array.item_remembering, R.layout.remembering_layout);
        autoCompleteRemembering.setAdapter(adapterRemembering);

        //self care
        autoCompleteSelfcare = findViewById(R.id.auto_complete_selfcare);
        adapterSelfcare = ArrayAdapter.createFromResource(this, R.array.item_selfcare, R.layout.selfcare_layout);
        autoCompleteSelfcare.setAdapter(adapterSelfcare);

        //Disability
        autoCompleteDisability = findViewById(R.id.auto_complete_disability);
        adapterDisability = ArrayAdapter.createFromResource(this, R.array.item_disability, R.layout.disability_layout);
        autoCompleteDisability.setAdapter(adapterDisability);
//Maritual Status
        autoCompleteMaritual = findViewById(R.id.auto_complete_maritual);
        adapterMaritual = ArrayAdapter.createFromResource(this, R.array.item_maritul, R.layout.maritual_layout);
        autoCompleteMaritual.setAdapter(adapterMaritual);

        //birthcirtificate

        autoCompleteBirthcirtificate = findViewById(R.id.auto_complete_birthcirtificate);
        adapterBirthcirtificate = ArrayAdapter.createFromResource(this, R.array.item_birthCertificate, R.layout.birth_cirtification);
        autoCompleteBirthcirtificate.setAdapter(adapterBirthcirtificate);

        //education
        autoCompleteEducation = findViewById(R.id.auto_complete_education);
        adapterEducation = ArrayAdapter.createFromResource(this, R.array.item_education, R.layout.education_layout);
        autoCompleteEducation.setAdapter(adapterEducation);

        //education attainment
        autoEducationAttainment = findViewById(R.id.auto_complete_educationAttain);
        adapterEductionAttainment = ArrayAdapter.createFromResource(this, R.array.item_education_attain, R.layout.education_attainment);
        autoEducationAttainment.setAdapter(adapterEductionAttainment);

        //education level
        autoCompleteEducationLevel = findViewById(R.id.auto_complete_education_level);
        adapterEducationLevel = ArrayAdapter.createFromResource(this, R.array.item_education_level, R.layout.level_of_education);
        autoCompleteEducationLevel.setAdapter(adapterEducationLevel);

        //death
        autoCompleteDeath = findViewById(R.id.auto_complete_dealth);
        adapterDeath = ArrayAdapter.createFromResource(this, R.array.item_dealth, R.layout.item_death_layout);
        autoCompleteDeath.setAdapter(adapterDeath);

        //nature of death
        autoCompleteNatureDeath = findViewById(R.id.auto_complete_dealth_couse);
        adapterNatureDeath = ArrayAdapter.createFromResource(this, R.array.item_couse_death, R.layout.item_nature_death_layout);
        autoCompleteNatureDeath.setAdapter(adapterNatureDeath);

        //pregdealth
        autoCompleteTextnatuerdealth = findViewById(R.id.auto_complete_preDealth);
        adapterpregdeath = ArrayAdapter.createFromResource(this, R.array.item_dealth_nature, R.layout.item_nature_death_layout);
        autoCompleteTextnatuerdealth.setAdapter(adapterpregdeath);

        //child dealth

        childDeath = findViewById(R.id.auto_complete_ChildDealth);
        adapterAfterBirth = ArrayAdapter.createFromResource(this, R.array.item_dealth_nature, R.layout.item_nature_death_layout);
        childDeath.setAdapter(adapterAfterBirth);


        autoCompleteTextAgriculture = findViewById(R.id.auto_complete_Agriculture);
        adapterAgriculture = ArrayAdapter.createFromResource(this, R.array.item_dealth_nature, R.layout.item_nature_death_layout);
        autoCompleteTextAgriculture.setAdapter(adapterAgriculture);


        //
        btnSendData = findViewById(R.id.sendData);
        regio = findViewById(R.id.region);
        distric = findViewById(R.id.didtrict);
        kat = findViewById(R.id.waddd);
        kijij = findViewById(R.id.kijiji);
        stret = findViewById(R.id.street);
        TextInputLayout kodi_ya_ulaiya = findViewById(R.id.coudeUlaiya);
        TextInputLayout sehemu_anapoishi = findViewById(R.id.SehemuAnapoishi);
        TextInputLayout sehemu_anapopatikana = findViewById(R.id.sehemu_anapopatikana);
        TextInputLayout Miaka_kamil = findViewById(R.id.miaka);
        TextInputLayout jinaKml = findViewById(R.id.jinakamili);


        databaseReferenceAllperson = FirebaseDatabase.getInstance().getReference().child("locationTracking();");
        databaseReference = FirebaseDatabase.getInstance().getReference("identification");


        btnSendData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toastBtn();


            }

            private void toastBtn() {


                String region = regio.getEditText().getText().toString().trim();
                String kodi_namba_ya_ulaiya = kodi_ya_ulaiya.getEditText().getText().toString().trim();
                String sehemu_anapoishi_kwa_sasa = sehemu_anapoishi.getEditText().getText().toString().trim();
                String sehemu_anapopatikana_sana = sehemu_anapopatikana.getEditText().getText().toString().trim();
                String district = distric.getEditText().getText().toString().trim();
                String miaka_kamili = Miaka_kamil.getEditText().getText().toString().trim();
                String kata = kat.getEditText().getText().toString().trim();
                String kijiji = kijij.getEditText().getText().toString().trim();
                String streat = stret.getEditText().getText().toString().trim();
                String relationShip = autoCompleteTextView.getText().toString();
                String Gender = autoCompleteTextView1.getText().toString();
                String Miaka = Miaka_kamil.getEditText().getText().toString();
                String Albinism = autocompleteAlbinism.getText().toString();
                String seeing = autocompleteSeeing.getText().toString();
                String hearing = autoCompletehearing.getText().toString();
                String working = autoCompleteWorking.getText().toString();
                String remebering = autoCompleteWorking.getText().toString();
                String selfcare = autoCompleteSelfcare.getText().toString();
                String disability = autoCompleteDisability.getText().toString();
                String martualstatus = autoCompleteMaritual.getText().toString();
                String birthcerticate = autoCompleteBirthcirtificate.getText().toString();
                String educatuion = autoCompleteEducation.getText().toString();
                String educatuion_attainment = autoEducationAttainment.getText().toString();
                String educatuion_level = autoCompleteEducationLevel.getText().toString();
                String dealth_occur_during_preg = autoCompleteTextnatuerdealth.getText().toString();
                String dealth = autoCompleteDeath.getText().toString();
                String Dealth_occur_during_child = childDeath.getText().toString();
                String Agriculture = autoCompleteTextAgriculture.getText().toString();
                String caurseOfdealth = autoCompleteNatureDeath.getText().toString();



                if (TextUtils.isEmpty(region)){
                    regio.setError("please fill region");
                    regio.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(district)){
                    distric.setError("please fill district");
                    distric.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(kata)){
                    kat.setError("please fill ward");
                    kat.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(streat)){
                    stret.setError("please fill street");
                    stret.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(streat)){
                    stret.setError("please fill street");
                    stret.requestFocus();
                    return;
                }
                else if (TextUtils.isEmpty(relationShip)){
                    autoCompleteTextView.setError("please select relationship status");
                    autoCompleteTextView.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(Gender)){
                    autoCompleteTextView1.setError("please select gender status");
                    autoCompleteTextView1.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(Miaka)){
                    Miaka_kamil.setError("please select year status");
                    Miaka_kamil.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(Albinism)){
                    autocompleteAlbinism.setError("please select albinism status");
                    autocompleteAlbinism.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(seeing)){
                    autocompleteSeeing.setError("please select seeing status");
                    autocompleteSeeing.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(hearing)){
                    autoCompletehearing.setError("please select hearing status");
                    autoCompletehearing.requestFocus();
                    return;
                }

                else if (TextUtils.isEmpty(working)){
                    autoCompleteWorking.setError("please select working status");
                    autoCompleteWorking.requestFocus();
                }
                else if (TextUtils.isEmpty(remebering)){
                    autoCompleteWorking.setError("please select remembering status");
                    autoCompleteWorking.requestFocus();
                }

                else if (TextUtils.isEmpty(selfcare)){
                    autoCompleteSelfcare.setError("please select self-care status");
                    autoCompleteSelfcare.requestFocus();
                }

                else if (TextUtils.isEmpty(disability)){
                    autoCompleteDisability.setError("please select disability status");
                    autoCompleteDisability.requestFocus();
                }

                else if (TextUtils.isEmpty(martualstatus)){
                    autoCompleteMaritual.setError("please select martial  status");
                    autoCompleteMaritual.requestFocus();
                }

                else if (TextUtils.isEmpty(birthcerticate)){
                    autoCompleteBirthcirtificate.setError("please select birthday status");
                    autoCompleteBirthcirtificate.requestFocus();
                }

                else if (TextUtils.isEmpty(educatuion)){
                    autoCompleteEducation.setError("please select birthday status");
                    autoCompleteEducation.requestFocus();
                }

                else if (TextUtils.isEmpty(educatuion_attainment)){
                    autoEducationAttainment.setError("please select education attainment status");
                    autoEducationAttainment.requestFocus();
                }

                else if (TextUtils.isEmpty(educatuion_level)){
                    autoCompleteEducationLevel.setError("please select education level status");
                    autoCompleteEducationLevel.requestFocus();
                }

                else if (TextUtils.isEmpty(dealth_occur_during_preg)){
                    autoCompleteTextnatuerdealth.setError("please select dealth  cause status");
                    autoCompleteTextnatuerdealth.requestFocus();
                }

                else if (TextUtils.isEmpty(dealth)){
                    autoCompleteDeath.setError("please select dealth  cause status");
                    autoCompleteDeath.requestFocus();
                }

                else if (TextUtils.isEmpty(dealth_occur_during_preg)){
                    autoCompleteDeath.setError("please select dealth  cause status");
                    autoCompleteDeath.requestFocus();
                }



                Identification identification = new Identification(region, district, kata, kijiji, streat, relationShip, Gender, Miaka, Albinism, seeing, hearing, working, remebering, selfcare, disability, martualstatus, birthcerticate, educatuion, educatuion_attainment, educatuion_level, dealth, caurseOfdealth, kodi_namba_ya_ulaiya, sehemu_anapoishi_kwa_sasa, sehemu_anapopatikana_sana, miaka_kamili, dealth_occur_during_preg, Dealth_occur_during_child, Agriculture);
                databaseReference.push().setValue(identification).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                        if (task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "successful", Toast.LENGTH_SHORT).show();

                            Intent i = new Intent(getApplicationContext(),short_form.class);
                            startActivity(i);
                        }
                    }
                });


                //all peron
                String jina_kamili = jinaKml.getEditText().getText().toString();


                //object all person


            }

        });}

}



