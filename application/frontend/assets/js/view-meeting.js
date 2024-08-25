const timetableData = {
    "January 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA] </td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "February 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "March 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "April 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business(Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "May 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector) ">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "June 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "July 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "August 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueB]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "September 2024": `
        <!-- Add September's timetable data -->
        <tr>
            <td class="time">9:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "October 2024": `
        <tr>
            <td class="time">9:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "November 2024": `
          <tr>
            <td class="time">9:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
    "December 2024": `
         <tr>
            <td class="time">9:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10:00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">11:00 AM</td>
            <td></td>
            <td class="RoomA blue lab" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td class="RoomC green" data-tooltip="Conference Call  By Manager C (Conference Call Facility)">RoomC [VenueC]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">12:00 PM</td>
            <td></td>
            <td class="RoomA navy" data-tooltip="Business by Manager D (Projector)">RoomA [VenueA]</td>
            <td class="RoomC red" data-tooltip="Business by Manager D (Projector)">RoomC [VenueC]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">1:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">2:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomB purple" data-tooltip="Online Training by Manager B (Wifi & Projector)">RoomB [VenueA]</td>
            <td class="RoomD orange" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">3:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">4:00 PM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td class="RoomD orange lab" data-tooltip="Business by Manager D (Projector)">RoomD [VenueD]</td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">5:00 PM</td>
            <td class="RoomA blue" data-tooltip="Class Room Training by ManagerA (White Board & Projector)">RoomA [VenueA]</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
    `,
};

let currentMonthIndex = 7; // August is the 8th month (index 7)

function updateMonthYear() {
    const months = [
        "January", "February", "March", "April", "May", "June", "July", "August",
        "September", "October", "November", "December"
    ];
    const year = 2024;
    document.getElementById('month-year').textContent = `${months[currentMonthIndex]} ${year}`;
}

function updateTimetable() {
    const months = [
        "January 2024", "February 2024", "March 2024", "April 2024", "May 2024", "June 2024", "July 2024", "August 2024",
        "September 2024", "October 2024", "November 2024", "December 2024"
    ];
    updateMonthYear();
    document.getElementById('timetable-body').innerHTML = timetableData[months[currentMonthIndex]] || `
        <tr>
            <td class="time">9.00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <tr>
            <td class="time">10.00 AM</td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <!-- More rows as needed -->
    `;
}

document.getElementById('prev-month').addEventListener('click', () => {
    if (currentMonthIndex > 0) {
        currentMonthIndex--;
    }
    updateTimetable();
});

document.getElementById('next-month').addEventListener('click', () => {
    if (currentMonthIndex < 11) {
        currentMonthIndex++;
    }
    updateTimetable();
});

// Initialize with the current month
updateTimetable();
document.addEventListener('DOMContentLoaded', function() {
    var modal = document.getElementById('meeting-modal');
    var closeBtn = document.querySelector('.close-btn');

    // Show modal with meeting details when a cell is clicked
    document.querySelectorAll('td[data-meeting]').forEach(function(cell) {
        cell.addEventListener('click', function() {
            var meetingData = JSON.parse(cell.getAttribute('data-meeting'));
            document.getElementById('modal-title').innerText = meetingData.title;
            document.getElementById('modal-date-time').innerText = meetingData.date + ' ' + meetingData.time;
            document.getElementById('modal-room').innerText = meetingData.room;
            document.getElementById('modal-participants').innerText = meetingData.participants;
            document.getElementById('modal-type').innerText = meetingData.type;
            document.getElementById('modal-amenities').innerText = meetingData.amenities;
            document.getElementById('modal-status').innerText = meetingData.status;
            document.getElementById('modal-notes').innerText = meetingData.notes;

            modal.style.display = 'block';
        });
    });

    // Close the modal when the user clicks on the close button
    closeBtn.addEventListener('click', function() {
        modal.style.display = 'none';
    });

    // Close the modal when the user clicks anywhere outside of the modal
    window.addEventListener('click', function(event) {
        if (event.target == modal) {
            modal.style.display = 'none';
        }
    });
});

