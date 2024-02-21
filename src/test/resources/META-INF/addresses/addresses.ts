// @ts-ignore
import { AddressType } from '../graphql/types.codegen';
const addressesI18n = {
    'Addresses.loading': 'Načítání',
    'Addresses.error': 'Chyba při načítání adres',
    'Addresses.title': 'Moje adresy',
    'Addresses.pageTitle': 'Moje adresy',
    'Addresses.emptyHeading': 'Zatím jste si nepřidali žádnou adresu',
    'Addresses.emptyText':
        'Urychlete si nakupování a přidejte si sem své adresy. Při vašem dalším nákupu je budete mít automaticky předvyplněné.',
    [`Addresses.${AddressType.BILLING}Addresses`]: 'Fakturační adresy',
    [`Addresses.new${AddressType.BILLING}Address`]: 'Nová fakturační adresa',
    [`Addresses.${AddressType.BILLING}Empty`]:
        'Zatím jste si nepřidali žádnou fakturační adresu.',
    [`Addresses.${AddressType.DELIVERY}Addresses`]: 'Dodací adresy',
    [`Addresses.new${AddressType.DELIVERY}Address`]: 'Nová dodací adresa',
    [`Addresses.${AddressType.DELIVERY}Empty`]:
        'Zatím jste si nepřidali žádnou dodací adresu.',
};
export default addressesI18n;
