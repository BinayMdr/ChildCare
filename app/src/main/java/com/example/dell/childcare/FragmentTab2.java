package com.example.dell.childcare;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentTab2.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentTab2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentTab2 extends Fragment {
    private static final String TAG = "Tab2Fragment";

    private ImageButton a,b,c,d,e,f,g,h,i,j,k,l,m,n,o,p,q,r,s,t,u,v,w,x,y,z;
    private MediaPlayer am,bm,cm,dm,em,fm,gm,hm,im,jm,km,lm,mm,nm,om,pm,qm,rm,sm,tm,um,vm,wm,xm,ym,zm;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fragment_tab2,container,false);
        a=view.findViewById(R.id.a);
        b=view.findViewById(R.id.b);
        c=view.findViewById(R.id.c);
        d=view.findViewById(R.id.d);
        e=view.findViewById(R.id.e);
        f=view.findViewById(R.id.f);
        g=view.findViewById(R.id.g);
        h=view.findViewById(R.id.h);
        i=view.findViewById(R.id.i);
        j=view.findViewById(R.id.j);
        k=view.findViewById(R.id.k);
        l=view.findViewById(R.id.l);
        m=view.findViewById(R.id.m);
        n=view.findViewById(R.id.n);
        o=view.findViewById(R.id.o);
        p=view.findViewById(R.id.p);
        q=view.findViewById(R.id.q);
        r=view.findViewById(R.id.r);
        s=view.findViewById(R.id.s);
        t=view.findViewById(R.id.t);
        u=view.findViewById(R.id.u);
        v=view.findViewById(R.id.v);
        w=view.findViewById(R.id.w);
        x=view.findViewById(R.id.x);
        y=view.findViewById(R.id.y);
        z=view.findViewById(R.id.z);
        am=MediaPlayer.create(getContext(),R.raw.a);
        bm=MediaPlayer.create(getContext(),R.raw.b);
        cm=MediaPlayer.create(getContext(),R.raw.c);
        dm=MediaPlayer.create(getContext(),R.raw.d);
        em=MediaPlayer.create(getContext(),R.raw.e);
        fm=MediaPlayer.create(getContext(),R.raw.f);
        gm=MediaPlayer.create(getContext(),R.raw.g);
        hm=MediaPlayer.create(getContext(),R.raw.h);
        im=MediaPlayer.create(getContext(),R.raw.i);
        jm=MediaPlayer.create(getContext(),R.raw.j);
        km=MediaPlayer.create(getContext(),R.raw.k);
        lm=MediaPlayer.create(getContext(),R.raw.l);
        mm=MediaPlayer.create(getContext(),R.raw.m);
        nm=MediaPlayer.create(getContext(),R.raw.n);
        om=MediaPlayer.create(getContext(),R.raw.o);
        pm=MediaPlayer.create(getContext(),R.raw.p);
        qm=MediaPlayer.create(getContext(),R.raw.q);
        rm=MediaPlayer.create(getContext(),R.raw.r);
        sm=MediaPlayer.create(getContext(),R.raw.s);
        tm=MediaPlayer.create(getContext(),R.raw.t);
        um=MediaPlayer.create(getContext(),R.raw.u);
        vm=MediaPlayer.create(getContext(),R.raw.v);
        wm=MediaPlayer.create(getContext(),R.raw.w);
        xm=MediaPlayer.create(getContext(),R.raw.x);
        ym=MediaPlayer.create(getContext(),R.raw.y);
        zm=MediaPlayer.create(getContext(),R.raw.z);

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                am.start();
            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bm.start();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cm.start();
            }
        });
        d.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dm.start();
            }
        });
        e.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                em.start();
            }
        });
        f.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fm.start();
            }
        });
        g.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gm.start();
            }
        });
        h.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hm.start();
            }
        });
        i.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im.start();
            }
        });
        j.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                jm.start();
            }
        });
        k.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                km.start();
            }
        });
        l.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lm.start();
            }
        });
        m.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mm.start();
            }
        });
        n.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nm.start();
            }
        });
        o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                om.start();
            }
        });
        p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pm.start();
            }
        });
        q.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                qm.start();
            }
        });
        r.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rm.start();
            }
        });
        s.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sm.start();
            }
        });
        t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tm.start();
            }
        });
        u.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                um.start();
            }
        });
        v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vm.start();
            }
        });
        w.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wm.start();
            }
        });
        x.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                xm.start();
            }
        });
        y.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ym.start();
            }
        });
        z.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zm.start();
            }
        });
        return view;

    }
}
