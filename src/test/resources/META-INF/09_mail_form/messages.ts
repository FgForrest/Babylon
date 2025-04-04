const messagesI18n = {
    'availability.color.ALWAYS_AVAILABLE': 'availability--available',
    'availability.color.NOT_AVAILABLE': 'availability--unavailable',
    'availability.color.DEPEND_ON_STOCK': `{count, plural,
  =0 {availability--unavailable}
  other {availability--available}
  }`,
    'availability.color.ALL_DEPEND_ON_STOCK': `{count, plural,
  =0 {availability--unavailable}
  other {availability--available}
  }`,
    'availability.text.ALWAYS_AVAILABLE': 'Skladem',
    'availability.text.NOT_AVAILABLE': 'Momentálně nedostupné',
    'availability.text.DEPEND_ON_STOCK': `{count, plural,
  =0 {Nedostupné}
  =1 {Poslední kus}
  =2 {Poslední kusy}
  =3 {Poslední kusy}
  =4 {Poslední kusy}
  other {Skladem}
  }`,
    'availability.text.ALL_DEPEND_ON_STOCK': `{count, plural,
  =0 {Nedostupné}
  =1 {Poslední kus}
  =2 {Poslední kusy}
  =3 {Poslední kusy}
  =4 {Poslední kusy}
  other {Skladem}
  }`,
    'productDetail.availability.text.ALWAYS_AVAILABLE': 'Skladem',
    'productDetail.availability.text.NOT_AVAILABLE': 'Momentálně nedostupné',
    'productDetail.availability.text.DEPEND_ON_STOCK': `{count, plural,
  =0 {Momentálně nedostupné}
  =1 {Skladem poslední kus}
  =2 {Skladem poslední kusy}
  =3 {Skladem poslední kusy}
  =4 {Skladem poslední kusy}
  other {Skladem}
  }`,
    'productDetail.availability.text.ALL_DEPEND_ON_STOCK': `{count, plural,
  =0 {Momentálně nedostupné}
  =1 {Skladem poslední kus}
  =2 {Skladem poslední kusy}
  =3 {Skladem poslední kusy}
  =4 {Skladem poslední kusy}
  other {Skladem}
  }`,
    contact_hours: '(Po - Ne: 8 - 16)',
    contact_name: 'Zákaznická linka',
    contact_email: 'test@juan.com',
    contact_phone: '+420 773 777 888',
    contact_linkedin: 'https://linkedin.com',
    contact_facebook: 'https://facebook.com',
    contact_youtube: 'https://youtube.com',
    contact_instagram: 'https://instagram.com',
    UspList_item1: '13 prodejen po celé ČR',
    UspList_item2: 'Doprava od 1000 Kč zdarma',
    UspList_item3: 'Rychlé doručení',
    UspList_item4: 'Bezpečná platba',
    UspList_item1_ico: 'marker',
    UspList_item2_ico: 'truck',
    UspList_item3_ico: 'clock',
    UspList_item4_ico: 'lock',
};
export default messagesI18n;
