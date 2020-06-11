package me.posmajanius.advancemobileprogramming_uts.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import me.posmajanius.advancemobileprogramming_uts.R;
import me.posmajanius.advancemobileprogramming_uts.two.TwoAdapter;
import me.posmajanius.advancemobileprogramming_uts.two.TwoModel;


public class CoursesFragment extends Fragment {
    private ArrayList<TwoModel> twoModels = new ArrayList<>();
    private TwoAdapter twoAdapter;


    public CoursesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_courses, container, false);
        addData();
        @SuppressLint("WrongConstant") LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        RecyclerView recyclerView = view.findViewById(R.id.rv_program);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        TwoAdapter twoAdapter = new TwoAdapter(getContext(), twoModels);
        recyclerView.setAdapter(twoAdapter);
        return view;
    }
    void addData() {
        twoModels = new ArrayList<>();
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Teknik Eletro", "Program Studi Teknik Elektro diarahkan sebagai Centre of Excellence dalam pembelajaran dan riset, dengan spesialisasi di bidang teknologi komunikasi mutakhir dan manajemen energi listrik. Teknik Elektro merupakan inti dunia modern, mulai dari komputer sampai ke sirkuit digital, fotonik dan termasuk juga energi terbarukan (renewable) dan elektro-medika. Potensi dan peluang sebagai lulusan Teknik Elektro sangat bervariasi, mulai karier di sektor telekomunikasi, teknologi informasi, otomotif, energi, sampai ke sektor aerospace (ruang angkasa).",
                        "School Of Engineering And Technology", " 600 "));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Teknik Perminyakan", "Minyak dan gas merupakan sumber daya yang membutuhkan teknik penanganan yang tepat, karena perlu waktu lama bagi minyak dan gas untuk terbaharukan. Karenanya ahli di bidang perminyakan sangat dibutuhkan. Untuk kuliah di program studi Teknik Perminyakan mahasiswa mempelajari dengan matematika, fisika, dan kimia. Dengan zaman yang serba canggih in proses perhitungan bisa digunakan dengan kalkulator dan software khusus perminyakan, jadi jangan khawatir kalau tidak terlalu menguasai subjek sains di atas. Selain itu di semester awal akan dipelajari matematika dan fisika dasar sebelum masuk ke mata kuliah khusus dan praktikum. Mahasiwa juga akan mendapatkan pengalaman sebagai engineer di lapangan migas di salah satu semester yang diselenggarakan.\n" +
                "\n" +
                "Apa itu Teknik Perminyakan?\n" +
                "\n" +
                "Teknik perminyakan mempelajari cara mencari sumber minyak dan gas dibawah permukaan bumi, dengan cara paling aman dan efisien untuk membawa sumber daya tersebut ke muka bumi. Seiring dengan tuntutan perkembangan zaman, jurusan ini juga lebih inovatif, dengan mencari cara untuk menghasilkan energi yang lebih bersih dan meminimalkan emisi karbon.\n" +
                "\n" +
                " ",
                "School Of Engineering And Technology", "700"));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Sistem Informasi", "Didukung dengan sertifikasi international dari Oracle Academy, mahasiswa lulusan program studi Sistem Informasi mampu bersaing secara profesional baik di dalam negeri maupun di luar negeri.",
                "School Of Engineering And Technology", "650"));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Teknik Sipil", "Program Studi Teknik Sipil TAU menawarkan pendidikan Teknik Sipil yang berbasis riset untuk menunjang percepatan pembangunan infra-struktur Ramah lingkungan Indonesia.\n" +
                "\n" +
                "Teknik Sipil mempelajari perancangan dan konstruksi bangunan fisik untuk prasarana transportasi seperti jalan, jembatan, kanal, bendungan, bandar udara, pelabuhan, perumahan, bangunan tingkat tinggi, infra-struktur industri petrokimia dan anjungan lepas pantai. Sarjana lulusan Teknik Sipil bekerja pada sektor pembangunan kota, nasional, privat swasta hingga perusahaan multi-national.\n" +
                "\n" +
                "Di dalam usianya yang masih muda, Teknik Sipil TAU sudah ikut terlibat di berbagai kegiatan berskala interna\u00ADsional seperti seminar dan program kemahasiswaan di dalam dan luar negeri.",
                "School Of Engineering And Technology", "600"));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Teknik Informatika", "Dengan kemajuan teknologi yang semakin pesat, program studi Teknik Informatika hadir untuk memenuhi kebutuhan industri saat ini. Penggunaan teknologi yang terkini di dalam pembelajaran program studi ini memberikan pengalaman yang menarik bagi mahasiswa dan mahasiswi di Tanri Abeng University.\n" +
                "\n" +
                "Didukung dengan sertifikasi international dari Oracle Academy, mahasiswa lulusan program studi Teknik Informatika mampu bersaing secara profesional baik di dalam negeri maupun di luar negeri.",
                "School Of Engineering And Technology", "450"));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Teknik Arsitektur", "Arsitektur TAU merupa\u00ADkan sekolah arsitektur di Indonesia yang menawarkan pen\u00ADdidikan arsitektur yang berbasis pada prinsip perancangan arsitektur bekelanjutan (sustainable architecture) yang diterapkan dalam lingkup pembelajaran perancangan dalam skala mikro (ruang dalam), meso (bangunan dan lingkungannya) dan makro (kawasan). Selain pembelajaran dalam bidang arsitektur berkelanjutan, Arsitektur TAU juga membekali mahasiswa dengan pengetahuan di bidang pemanfaatan teknologi visualisasi arsitektur dan manajemen kepemimpinan sebagai kompetensi penunjang.\n" +
                "\n" +
                "Pengembangan Program Studi Arsitektur TAU diprakarsai oleh pakar arsitektur hijau Indonesia, Prof. Ir. Tri Harso Karyono, MA, Ph.D yang didukung oleh tenaga pengajar lulusan dalam dan luar negeri yang juga memiliki pengalaman di bidang akademisi dan praktisi. Dalam usianya yang masih muda, sivitas akademika Arsitektur TAU juga berhasil terlibat dalam beberapa kegiatan berskala internasional yang diselenggarakan di dalam maupun di luar Kampus TAU.",
                "School Of Engineering And Technology", " 500"));

        twoModels.add(new TwoModel(R.drawable.logo_tau, "Administrasi Bisnis", "Mayoritas universitas di Indonesia tidak membekali lulusannya untuk menjadi seorang profesional yang handal dan siap pakai untuk menjadi pemimpin dibidang bisnis dimasa yang akan datang dan lebih fokus keaspek pendalaman teori. Padahal, saat ini Indonesia sangatlah kekurangan profesional dibidang bisnis yang siap pakai dan handal yang dapat membawa ekonomi Indonesia kelevel yang lebih tinggi.\n" +
                "\n" +
                "Program studi (prodi) Administrasi Bisnis TAU hadir untuk menghasilkan lulusan yang siap pakai, handal, serta profesional dibidang bisnis dan manajemen; menghasilkan lulusan yang dapat bersaing setara bahkan mengungguli profesional bisnis ditingkat global. Prodi ini menawarkan kurikulum multi bisnis yang mempersiapkan lulusannya untuk menjadi seorang manajer dan pengusaha dibidang bisnis.\n" +
                "\n" +
                "Untuk mengakomodir minat dan bakat mahasiswa dibidang bisnis, prodi Administrasi Bisnis TAU menawarkan lima konsentrasi, yaitu Kewirausahaan, Perbankan Investasi, Strategi dan Inovasi, Bisnis Internasional, dan Perbankan Syariah.",
                "School Of Management And Leadership", "550"));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Manajemen", "Program pembelajaran di program  studi (Prodi) Manajemen  dirancang agar mahasiswa dapat siap terjun secara profesional baik di dunia bisnis maupun di dunia kerja. Tidak hanya di Indonesia tapi secara global. Untuk itu kami membangun keahlian mahasiswa  secara akademik dan soft skills.\n" +
                "\n" +
                "Kurikulum kami didesain agar  mahasiswa  tidak hanya belajar tentang teori Manajemen secara mendalam  tetapi juga mengaplikasikan di dunia kerja/bisnis dengan mengikuti perkembangan zaman.   Selain itu, mahasiswa akan mengembangkan kemampuan untuk menganalisis, berkomunikasi, pemecahaan masalah dan team building.\n" +
                "\n" +
                "Kami menerapkan sistem pembelajaran dengan beberapa metode sehingga memberikan pengalaman yang unik untuk para mahasiswa. Survey kepuasaan yang dilakukan menyebutkan bahwa 98% persen dari mahasiswa program studi Manajemen puas dengan system dan pengalaman yang mereka dapatkan selama di TAU seperti testemoni mahasiswa dan alumni TAU. ",
                "School Of Management And Leadership", "680"));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Ilmu Komunikasi", "Kebutuhan perusahaan yang semakin meningkat di bidang komunikasi dalam upaya menunjang tujuan perusahaan.\n" +
                "Kombinasi antara teori dan praktik akan lebih mempersiapkan mahasiswa menjadi seorang profesional di bidang Ilmu Komunikasi.\n" +
                "Proses belajar yang unik dan pengalaman memperkenalkan mahasiswa ke berbagai institusi, semakin menambah pengetahuan mahasiswa tentang dunia kerja.",
                "School Of Management And Leadership", "750"));
        twoModels.add(new TwoModel(R.drawable.logo_tau, "Akuntansi", "Program studi akuntansi di rancang sebagai program studi yang berdaya saing tinggi, penuh tantangan dan memerlukan keuletan yang guna mempersiapkan pemikiran kritis, pemecahan masalah, berkomunikasi lisan dan tertulis, pengambilan keputusan serta membutuhkan pembelajaran yang berkesinambungan setelah kelulusan. Akuntansi adalah tentang bagaimana cara mengkomunikasikan informasi bernilai ekonomis dari sebuah kegiatan usaha kepada para pihak yang berkepentingan. Akuntansi adalah bahasa bisnis.\n" +
                "\n" +
                "Program sarjana akuntansi kami mengutamakan pendekatan praktisi yaitu dengan mendorong dan memastikan mahasiswa/mahasiswi untuk menguasai ilmu akuntansi melalui praktek.\n" +
                "\n" +
                "Sarjana akuntansi merupakan sebuah program studi yang komprehensif untuk mempersiapkan kualitas lulusan yang disyaratkan oleh organisasi akuntansi di Indonesia maupun Internasional. mahasiswa/mahasiswi juga akan diperkaya dengan pengetahuan yang di peroleh dari pengalaman kerja yang praktikal.\n" +
                "\n" +
                "Dengan memiliki gelar sarjana akuntansi dari TANRI ABENG UNIVERSITY, anda sebagai lulusan telah menguasai landasan pengetahuan akuntansi yang mumpuni dan solid serta memiliki pemahaman yang kuat dalam bidang manajemen, bisnis dan kewirausahaan.\n" +
                "\n" +
                "Untuk sukses dalam menjalani pendidikan di program studi Akuntansi, mahasiswa/mahasiswi diharapkan memiliki tingkat kedewasaan, motivasi dan disiplin diri yang tinggi.\n" +
                "\n" +
                "Di dalam program stusi akuntansi mahasiswa/mahasiswi dinilai berdasarkan seberapa jauh tingkat persiapan dan kinerja mereka\n" +
                "\n" +
                "Masing-masing kelas menampung sekitar 20 mahasiswa/mahasiswi, yang akan menjamin berlangsungnya diskusi secara akif selama proses pembelajaran.",
               "School Of Management And Leadership", "740"));
          }



}
