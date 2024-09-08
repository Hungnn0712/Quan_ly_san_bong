package com.example.myapplication.UI.nguoithue;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.myapplication.R;
import com.example.myapplication.UI.chusan.ChuSanActivity;
import com.example.myapplication.adapter.nguoi_thue_adapter.HomeAdapter;
import com.example.myapplication.dao.HomeDao;
import com.example.myapplication.itf.IClickitemHome;

import java.util.ArrayList;
import java.util.List;


public class HomeFragment extends Fragment {
    private RecyclerView rcvHome;
    private View mView;
    private FragmentActivity mHomeFragment;
    Button back,datsanc,sandadatc,eventc;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.activity_home_fragment, container, false);
        //datsanc = mView.findViewById(R.id.datsan);
        //sandadatc = mView.findViewById(R.id.sandathue);
        //eventc = mView.findViewById(R.id.event);
//        datsanc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(getContext(),CaSanFragment.class);
//                startActivity(i);
//            }
//        });
        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list
        imageList.add(new SlideModel(R.drawable.banner1, "Đá bóng cùng Công Phượng", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.banner3, "BIG SALE Tháng 8", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.banner2, "Shop giày", ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel(R.drawable.banner4, "Đá bóng cùng Quảng Hải", ScaleTypes.CENTER_CROP));
        ImageSlider imageSlider = mView.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);
        mHomeFragment = getActivity();
        rcvHome = mView.findViewById(R.id.rcvHome);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mHomeFragment);
        rcvHome.setLayoutManager(linearLayoutManager);

        HomeAdapter homeAdapter = new HomeAdapter(getListHome(), new IClickitemHome() {
            @Override
            public void onClickitemHome(HomeDao homeDao) {
                onClickGoToDetail(homeDao);
            }
        });
        rcvHome.setAdapter(homeAdapter);
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(mHomeFragment,DividerItemDecoration.VERTICAL);
        rcvHome.addItemDecoration(itemDecoration);
        return mView;
    }
    private List<HomeDao> getListHome() {
        List<HomeDao> list = new ArrayList<>();
        list.add(new HomeDao("Hội CĐV Nam Định","Nam thanh niên đi đá bóng bị đá gãy chân","Chiều ngày 9/8, trên trang Nam Dinh Football Club, Hội CĐV Nam Định đã ra thông báo chính thức giải thể Hội CĐV bóng đá Nam Định. Nội dung cụ thể như sau: \n" +
                "1. 100% biểu quyết thông qua việc dừng mọi hoạt động cổ vũ trên sân của Hội cổ động viên bóng đá Nam Định. \n" +
                "2. Hội sẽ bàn giao lại văn phòng cho Ban quản lý sân vận động Thiên Trường.\n" +
                "3. Ban chấp hành Hội cổ động viên bóng đá Nam Định không liên quan đến các hoạt động cổ vũ bóng đá của các thành viên.\n" +
                "4. Ban chấp hành Hội đề nghị các thành viên trong lúc tiến hành giải thể, tuyệt đối thực hiện nghiêm chỉnh mọi quy định của ban tổ chức sân, chính quyền địa phương cũng như quy định của pháp luật. \n" +
                "5. Về trang Facebook của hội sẽ đổi tên thành “Bóng đá Nam Định Xưa Và Nay” nhằm mục đích lưu giữ, phát huy: Hình Ảnh - Truyền Thống, phong trào Bóng Đá Nam Định Quá Khứ - Hiện Tại - Tương Lai.\n" +
                "6. Thông báo này chỉ có giá trị với các thành viên có thẻ hội viên và thẻ ban chấp hành Hội cổ động viên bóng đá Nam Định\n" +
                "Quyết định này được đưa ra trước khi Nam Định bước vào vòng 6, giai đoạn 2 V.League 2023. Trước đó, nhiều CĐV Nam Định không khỏi bức xúc, khi chứng kiến thất bại 1-2 của Nam Định trước Công An Hà Nội trên sân Thiên Trường ở vòng 4 giai đoạn 2 V.League 2023. \n" +
                "\n" +
                "\n" +
                "Một ngày sau trận đấu, hàng trăm CĐV thành Nam đã đến văn phòng CLB Nam Định để trả lại áo. Bên cạnh đó, họ cũng kêu gọi sẽ không đến sân để cổ vũ thầy trò HLV Vũ Hồng Việt thi đấu trong những loạt trận còn lại của mùa giải.\n" +
                "Sân Thiên Trường từng được xem là “chảo lửa” và là niềm tự hào của V.League trong những năm trở lại đây. Mỗi trận đấu của Nam Định trên sân nhà đều giống như một ngày hội. Đáng tiếc là sau những gì đã xảy ra thời gian qua, những người yêu mến bóng đá Nam Định đã cảm thấy tổn thương, mất đi niềm tin vào đội nhà.\n" +
                "Theo lịch thi đấu, Nam Định sẽ còn một trận sân nhà nữa khi tiếp đón Hà Tĩnh ở vòng đấu cuối cùng của giai đoạn 2 V.League 2023 diễn ra vào ngày 27/8. \n",R.drawable.anh1));
        list.add(new HomeDao("Đội tuyển nữ Việt Nam","Chuẩn bị ASIAD 19, Huỳnh Như chờ Lank còn Thùy Trang vắng mặt","Ngày mai (10.8), đội tuyển nữ Việt Nam sẽ tập trung trở lại tại Trung tâm đào tạo bóng đá trẻ Việt Nam (Hà Nội), để chuẩn bị cho ASIAD 19 diễn ra ở Trung Quốc trong tháng 9.\n" +
                "Ở đợt tập trung lần này, HLV Mai Đức Chung và các cộng sự bổ sung nhiều gương mặt trẻ như Nguyễn Thị Hoa, Phạm Thị Lan Anh (Hà Nội); Trần Thị Duyên, Nguyễn Thị Thùy Linh (Hà Nam), nâng số cầu thủ sinh sau năm 2000 của đội tuyển nữ Việt Nam lên 11 cầu thủ (trên tổng số 25 cầu thủ được triệu tập). \n" +
                "Việc gọi thêm những cầu thủ này lên tập trung cùng đội tuyển nằm trong kế hoạch đào tạo lớp kế cận cho đội tuyển nữ Việt Nam, chuẩn bị cho mục tiêu tương lai.\nĐối với trường hợp của Huỳnh Như, tiền đạo này vẫn đang trong quá trình hoàn tất hợp đồng với CLB Lank Vilaverdense, vì vậy việc Huỳnh Như có tham gia tập trung và thi đấu cùng đội tuyển nữ Việt Nam tại ASIAD 19 hay không, sẽ được xác nhận lại sau khi có sự thống nhất với câu lạc bộ chủ quản.\n" +
                "Đội không có Thùy Trang (sinh năm 1998), Thúy Nga (sinh năm 1990) như tại World Cup nữ 2023.\n",R.drawable.anh2));
        list.add(new HomeDao("Messi gọi, Ronaldo trả lời: ","\"Không chiến\" tuyệt đỉnh phút 87, gây sốt Cúp C1 Ả Rập","Phút 87 trận Al Nassr - Zamalek thuộc khuôn khổ lượt trận cuối bảng C Arab Champions Cup (Cúp Vô địch các Câu lạc bộ Ả Rập), Al Nassr đang bị dẫn 0-1. Nếu kết quả này duy trì đến khi trọng tài nổi hồi còi mãn cuộc, đương kim á quân Saudi Pro League sẽ bị loại.\n" +
                "Ronaldo ghi bàn giúp Al Nassr giành vé vào tứ kết Arab Champions Cup\n" +
                "Tuy nhiên trong tình cảnh khó khăn, Cristiano Ronaldo đã thể hiện đẳng cấp với pha lập công ấn định tỷ số 1-1. Phút 87, siêu sao người Bồ Đào Nha đón quả tạt bên cánh trái và bật cao đánh đầu tung lưới Zamalek.\n" +
                "Kết quả hòa vừa đủ để Al Nassr giành quyền vào tứ kết Arab Champions Cup với tư cách đội nhì bảng C (5 điểm/3 trận, hơn Zamalek 1 điểm), qua đó tiếp tục nuôi hy vọng chinh phục danh hiệu đầu tiên của mùa giải. \n" +
                "Đối với cá nhân Ronaldo, CR7 có bàn thắng thứ 2 trong 2 trận liên tiếp, cũng như bàn thắng bằng đầu thứ 146 trong sự nghiệp. Hiện anh đang nắm giữ kỷ lục ghi nhiều bàn thắng bằng đầu nhất lịch sử bóng đá (huyền thoại người Đức Gerd Muller xếp sau với 144 pha lập công). \n" +
                "Chưa hết, tiền đạo này còn đánh dấu mùa giải thứ 22 liên tiếp ghi bàn, thành tích mà bất kì cầu thủ nào trên thế giới cũng phải ao ước. \n" +
                "Trong ngày 3/8, đại kình địch của Ronaldo, Lionel Messi cũng thể hiện phong độ xuất sắc ở Mỹ với cú đúp giúp CLB chủ quản Inter Miami đánh bại Orlando City 3-1.\n" +
                "Dù chia tay bóng đá châu Âu, Ronaldo và Messi vẫn trở thành tâm điểm sau mỗi trận đấu nhờ danh tiếng, đẳng cấp lẫn tầm ảnh hưởng của mình. Màn trình diễn thăng hoa của bộ đôi siêu sao chắc chắn sẽ làm cho giải vô địch quốc gia Saudi Arabia (Saud Pro League) hay giải bóng đá nhà nghề Mỹ (MLS) thu hút sự quan tâm không kém các giải đấu hàng đầu châu Âu.\n",R.drawable.anh3));
        list.add(new HomeDao("Arteta:","'Không gì tuyệt hơn thắng đội mạnh nhất để đoạt Cup'","Arteta: 'Không gì tuyệt hơn thắng đội mạnh nhất để đoạt Cup'\n" +
                "Theo HLV Mikel Arteta, chiến thắng trước Man City ở Siêu Cup Anh sẽ tiếp thêm niềm tin và động lực cho Arsenal tại Ngoại hạng Anh mùa 2023-2024.\n" +
                "\"Cảm giác thật tuyệt\", Arteta nói sau chiến thắng trên sân Wembley tối 6/8. \"Tôi nghĩ không gì tuyệt hơn việc đoạt danh hiệu tại Wembley trước CLB hay nhất thế giới theo cách mà chúng tôi đã làm. Điều đó thực sự đáng khích lệ\".\n" +
                "Theo Arteta, Arsenal đã tạo nhiều khoảnh khắc tuyệt vời xuyên suốt trận đấu, đặc biệt trong hiệp một - thời điểm đội bóng của ông bỏ lỡ nhiều cơ hội. HLV người Tây Ban Nha cho rằng các cầu thủ của ông mắc lỗi tranh chấp ở giữa sân rồi phá bóng không tốt trong tình huống bị thủng lưới, nhưng ca ngợi họ giữ vững niềm tin, động lực để chiến đấu đến những giây cuối cùng rồi gỡ hòa 1-1 và thắng trên loạt luân lưu với tỷ số 4-1.\n" +
                "Sau trận HLV Pep Guardiola phàn nàn về thời gian bù giờ quá dài, nhưng Arteta tỏ ra thích thú với việc bóng đá Anh áp dụng quy định tương tự World Cup 2022. \"Giờ đây, các CLB phải suy nghĩ lại việc câu giờ. Còn chúng tôi phải chuẩn bị để thi đấu các trận 100 phút vì nó sẽ diễn ra hàng tuần\", nhà cầm quân 41 tuổi nói.\n" +
                "\n" +
                "Sau trận, thủ thành Aaron Ramsdale cho rằng Arsenal đã chứng minh có thể đánh bại Man City ở những cuộc đấu quyết định. Mùa trước, anh và đồng đội đã dẫn đầu trong hầu hết thời gian, nhưng cuối cùng lại thất bại trước Man City ở Ngoại hạng Anh. Khi được hỏi về phát biểu kể trên, Arteta đáp: \"Tôi không cần phải đồng ý hay không đồng ý. Đó là những gì các cầu thủ cảm nhận, và họ tin có thể đánh bại bất kỳ đội bóng nào. Đó là thách thức đặc biệt với sự trưởng thành và tần suất họ chơi các trận chung kết\".\n" +
                "\n" +
                "HLV Arteta nâng danh hiệu sau khi cùng Arsenal thắng ngược Man City ở trận tranh Siêu Cup Anh trên sân Wembley ngày 6/8. Ảnh: arsenal.com\n" +
                "Trận này, Arsenal sử dụng cả ba tân binh ngay từ đầu, gồm Kai Havertz, Declan Rice và Jurrien Timber. Họ không quá vượt trội về thế trận, nhưng tạo nhiều cơ hội hơn trong hiệp một. Phút 26, Havertz dứt điểm đập chân thủ môn Stefan Ortega rồi Gabriel Martinelli đá bồi không thành công. Phút 40, Havertz tiếp tục có cơ hội nhưng cú đá chân phải cận thành bị Ortega cản phá.\n" +
                "Bỏ lỡ nhiều cơ hội, Arsenal trả giá. Phút 77, Thomas Partey để Phil Foden vượt qua ở giữa sân, còn Kieran Tierney phá bóng không hết tầm, tạo điều kiện cho Cole Palmer cứa lòng về góc xa mở tỷ số cho Man City. Hiệp hai có tám phút bù giờ, và sau đó được nới thêm do có các cầu thủ chấn thương cần chăm sóc. Đến phút bù thứ 11, tiền đạo vào thay người Leandro Trossard sút trúng trung vệ Manuel Akanji khiến bóng đổi hướng trong khi thủ môn Ortega lỡ đà, gỡ hòa cho Arsenal.\n" +
                "Ở loạt đá luân lưu, trong khi Man City chỉ thành công với cú sút của Bernado Silva, bốn cầu thủ của Arsenal là Martin Odegaard, Trossard, Bukayo Saka và Fabio Vieira đều hoàn thành nhiệm vụ.\n" +
                "\n",R.drawable.anh4));
        list.add(new HomeDao("Messi ghi 7 bàn","Phô diễn \"ma thuật\" ở Mỹ, lại dễ giành Quả bóng vàng","Trận đấu thứ tư của Lionel Messi trong màu áo Inter Miami, lần này là chuyến làm khách đến sân của FC Dallas trong khuôn khổ vòng knock-out Leagues Cup. Và thêm một trận đấu nữa siêu sao người Argentina tiếp tục cho thấy đẳng cấp của cầu thủ vĩ đại bậc nhất lịch sử, chủ nhân của 7 danh hiệu Quả bóng vàng.\n" +
                "Messi tỏa sáng trong trận đấu với Dallas\n" +
                "\"Leo\" chỉ cần 6 phút bóng lăn để chọc thủng lưới Dallas. Cái chân trái của Messi vẫn sắc bén như ngày nào, và pha lập công ấy gợi nhớ lại những năm tháng hoàng kim cùng Barcelona bằng kịch bản quen thuộc: Jordi Alba trả ngược vừa tầm để Messi băng lên từ tuyến hai, dứt điểm hiểm hóc.\n" +
                "Khoảng thời gian sau đó chứng kiến sự khó nhọc của Inter Miami. Nhìn vào cách chơi của đội bóng này, người ta mới hiểu tại sao đội bóng của ông bầu David Beckham xếp bét bảng tại giải Nhà nghề Mỹ. Bởi lẽ, Inter Miami quá kém trong phòng ngự, để cho Dallas chọc thủng lưới tới 4 lần.\n" +
                "Messi không chỉ ghi bàn, anh còn là nguồn cảm hứng, là người kiến thiết lối chơi cho Inter Miami. Bàn thắng thứ hai của đội khách có xuất phát điểm là đường chọc khe siêu hạng của \"Leo\". Trong khi đó, bàn thứ ba cũng chính Messi thực hiện quả treo bóng khiến Farfan của Dallas đánh đầu phản lưới nhà.\n" +
                "Hơn hết ở phút 85, khi tỷ số đang là 4-3, Messi lại khiến tất cả phải gọi tên anh. Cú đá phạt đã trở thành thương hiệu hoàn toàn không cho thủ môn Paes của Dallas có cơ hội nào để cản phá.\n" +
                "Nhờ vậy, Messi lập cú đúp, nâng tổng thành tích ghi bàn cho Inter Miami lên con số 7 sau 4 trận, bên cạnh 1 đường kiến tạo. Và phải nhờ vào khoảnh khắc đỉnh cao của Messi, Inter Miami mới có cơ hội để tiếp tục bước vào loạt penalty đầy may rủi.\n" +
                "Trong loạt penalty ấy, Messi tiếp tục làm tốt nhiệm vụ của người đội trưởng khi anh thực hiện tốt quả penalty. Chính nó đã mở ra chiến thắng 5-3 trong loạt đấu này. Sau cùng, Inter Miami ghi danh vào tứ kết và giờ đây còn nguyên vẹn chinh phục danh hiệu Leagues Cup.\n" +
                "Như vậy, kể từ khi Messi ra mắt đến nay, Inter Miami toàn thắng 4 trận. Cứ chơi với phong độ hiện tại, dù chỉ là giải đấu tại Mỹ thì danh hiệu Quả bóng vàng thứ 8 sự nghiệp khó lòng thoát khỏi tay cầu thủ 36 tuổi này.\n",R.drawable.anh5));
        list.add(new HomeDao("Haaland \"tàng hình\" trận gặp Arsenal: ","Chỉ số tệ, đáp trả khi bị la ó","Hôm 6/8, Arsenal đã đánh bại Man City 4-1 trong loạt sút luân lưu để giành Siêu cúp Anh sau khi hai đội hòa nhau 1-1 trong thời gian thi đấu chính thức. Trận này, Haaland đã có màn trình diễn đáng thất vọng.\n" +
                "Haaland không tung ra nổi 1 cú sút về phía khung thành Arsenal\n" +
                "Theo thống kê của Sofascore, tiền đạo người Na Uy chỉ 13 lần chạm bóng và không tung ra nổi một cú dứt điểm trong trận Siêu cúp Anh với Arsenal trước khi bị HLV Pep Guardiola thay ra ở phút 62. Trên đường rời sân, Haaland đã giơ ba ngón tay để đáp trả những tiếng la ó của người hâm mộ Arsenal như để nhắc nhở các fan “Pháo thủ” rằng anh đã giành “cú ăn 3” vĩ đại cùng Man City mùa trước.\n" +
                "Đáng chú ý, Cole Palmer, người vào sân thay Haaland, chính là cầu thủ ghi bàn mở tỷ số cho Man City với cú cứa lòng đẹp mắt ở phút 77. Nhưng đến phút bù giờ thứ 11, Arsenal đã tìm được bàn gỡ nhờ công của Leandro Trossard. Trong loạt đá luân lưu, De Bruyne và Rodri thực hiện không thành công khiến nhà đương kim vô địch Ngoại hạng Anh nhận thất bại 1-4 và tuột mất danh hiệu đầu tiên của mùa giải mới.\n" +
                "Trên mạng xã hội Twitter, một tài khoản có tên Troll Football đã đăng một đoạn video quay cảnh HLV Ralph Hasenhuttl của Southampton theo kiểu ‘bình tĩnh nào’ ăn mừng bàn thắng vào lưới Arsenal mùa trước, với chú thích: “Người hâm mộ Premier League sau khi chứng kiến Haaland im tiếng trong trận tranh Siêu cúp Anh nhưng sau đó chợt nhớ ra rằng anh ta cũng từng có màn trình diễn tương tự như vậy hồi năm ngoái”.\n" +
                "Bố của Haaland, ông Alfie cũng \"không phải dạng vừa\" khi chia sẻ lại bài đăng chế giễu cậu con trai. Kèm theo đó, ông Alfie viết: “Làm tốt lắm Arsenal, chiến thắng tuyệt vời. Bây giờ các bạn hẳn phải là ứng cử viên nặng ký nhất cho chức vô địch mùa tới”, cùng theo biểu tượng nháy mắt đầy ẩn ý.\n",R.drawable.anh6));
        return list;
    }
    private void onClickGoToDetail(HomeDao homeDao){
        Intent intent = new Intent(getContext(), DetailHome.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("object_home",homeDao);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}